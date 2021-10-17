package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_13565 {
	
	private static int N, M;
	private static char[][] map;
	private static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[M][N];
		
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				
				if (i == 0 && map[i][j] == '0') {
					q.add(new Point(j, i));
				}
			}
		}
		System.out.println(bfs());
	}
	
	private static String bfs() {
		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { 1, 0, -1, 0 };
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			if (y == M - 1) {
				return "YES";
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (isInside(nx, ny) && map[ny][nx] == '0') {
					q.add(new Point(nx, ny));
					map[ny][nx] = '1';
				}
			}
		}
		return "NO";
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
	
	private static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
