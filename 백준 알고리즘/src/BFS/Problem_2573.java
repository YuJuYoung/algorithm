package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_2573 {
	
	private static int N, M;
	private static int[][] map;
	private static Point[][] point;
	private static boolean [][] visited;
	private static int[] dx = { 1, 0, 0, -1 }, dy = { 0, 1, -1, 0 };
	
	private static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		point = new Point[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] > 0) {
					point[i][j] = new Point(j, i);
				}
			}
		}
		
		int answer = 0;
		while (true) {
			visited = new boolean[N][M];
			int count = 0;
			
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < M - 1; j++) {
					if (map[i][j] > 0 && !visited[i][j]) {
						dfs(j, i);
						count++;
					}
				}
			}
			if (count >= 2) {
				System.out.println(answer);
				return;
			}
			if (count == 0) {
				break;
			}
			while (!q.isEmpty()) {
				Point tmp = q.poll();
				map[tmp.y][tmp.x] = 0;
			}
			answer++;
		}
		System.out.println(0);
	}
	
	private static void dfs(int x, int y) {
		visited[y][x] = true;
		
		int count = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (!visited[ny][nx]) {
				if (map[ny][nx] > 0) {
					dfs(nx, ny);
				} else {
					count++;
				}
			}
		}
		if (map[y][x] - count <= 0) {
			q.add(point[y][x]);
		} else {
			map[y][x] -= count;
		}
	}
	
	private static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
