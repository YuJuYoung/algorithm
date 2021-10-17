package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_19238 {
	
	private static int N, M, powN;
	private static int[][] map;
	private static boolean[][] visited;
	private static Point[][] point;
	
	private static Point t;
	private static int fuel;
	
	private static int[] dx = { 0, 1, -1, 0 };
	private static int[] dy = { 1, 0, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		powN = N * N;
		map = new int[N][N];
		point = new Point[N][N];
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				point[i][j] = new Point(j, i);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		t = point[y][x];
		
		int tmp = 1;
		while (tmp++ <= M) {
			st = new StringTokenizer(br.readLine());
			
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			map[y][x] = tmp;
			
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			map[y][x] = tmp + powN;
		}
		System.out.println(bfs(1));
	}
	
	private static int bfs(int n) {
		visited = new boolean[N][N];
		
		Queue<Point> q = new LinkedList<>();
		q.add(point[t.y][t.x]);
		visited[t.y][t.x] = true;
		
		int min = Integer.MAX_VALUE;
		Point pas = null;
		
		int count = 0;
		while (count <= fuel && !q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				Point p = q.poll();
				int x = p.x;
				int y = p.y;
				
				if (map[y][x] > 1 && map[y][x] <= powN) {
					min = count;
					
					if (pas == null) {
						pas = p;
					} else {
						if (pas.y > p.y) {
							pas = p;
						}
						if (pas.y == p.y && pas.x > p.x) {
							pas = p;
						}
					}
				}
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (isInside(nx, ny) && map[ny][nx] != 1 && !visited[ny][nx]) {
						q.add(point[ny][nx]);
						visited[ny][nx] = true;
					}
				}
			}
			if (++count > min) {
				break;
			}
		}
		
		if (pas != null) {
			fuel -= count;
			
			if (!des(pas)) {
				return -1;
			}
			if (n == M) {
				return fuel;
			}
			return bfs(n + 1);
		}
		return -1;
	}
	
	private static boolean des(Point pas) {
		visited = new boolean[N][N];
		
		Queue<Point> q = new LinkedList<>();
		q.add(pas);
		return false;
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
	
	private static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
