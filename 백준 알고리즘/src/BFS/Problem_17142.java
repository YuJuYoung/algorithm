package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_17142 {
	
	private static int N, M, all = 0, min = Integer.MAX_VALUE;
	private static char[][] map;
	private static boolean[][] visited;
	private static Point[][] point;
	private static Queue<Point> q = new LinkedList<>();
	private static List<Point> virus = new ArrayList<>();
	private static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		point = new Point[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j * 2);
				
				if (map[i][j] == '1') {
					continue;
				}
				point[i][j] = new Point(j, i);
				
				if (map[i][j] == '0') {
					all++;
				}
				if (map[i][j] == '2') {
					virus.add(point[i][j]);
				}
			}
		}
		if (all == 0) {
			System.out.println(0);
		} else {
			dfs(M, -1);
			System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		}
	}
	
	private static void dfs(int count, int index) {
		if (count == 0) {
			min = Math.min(min, bfs());
			q = new LinkedList<>();
			return;
		}
		
		for (int i = index + 1; i <= virus.size() - count; i++) {
			Point tmp = virus.get(i);
			q.add(point[tmp.y][tmp.x]);
			visited[tmp.y][tmp.x] = true;
			dfs(count - 1, i + 1);
			visited[tmp.y][tmp.x] = false;
		}
	}
	
	private static int bfs() {
		boolean[][] visited = new boolean[N][N];
		
		int time = 0, count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				Point tmp = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nx = tmp.x + dx[i];
					int ny = tmp.y + dy[i];
					
					if (isInside(nx, ny) && !visited[ny][nx] && map[ny][nx] != '1' && !visited[ny][nx]) {
						if (map[ny][nx] == '0') {
							if (++count == all) {
								return time + 1;
							}
						}
						visited[ny][nx] = true;
						q.add(point[ny][nx]);
					}
				}
			}
			time++;
			
			if (time == min) {
				break;
			}
		}
		return Integer.MAX_VALUE;
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
