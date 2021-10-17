package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_2151 {
	
	private static int N;
	private static char[][] map;
	private static boolean[][] visited;
	
	private static Queue<Point> q = new LinkedList<>();
	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				
				if (map[i][j] == '#' && q.isEmpty()) {
					q.add(new Point(j, i, -1, -3));
					visited[i][j] = true;
				}
			}
		}
		System.out.println(bfs());
	}
	
	private static int bfs() {
		while (!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			int c = p.c;
			int d = p.d;
			int last = (d + 2) % 2;
			
			for (int i = 0; i < 4; i++) {
				if (last == i) {
					continue;
				}
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nc = d == i ? c : c + 1;
				
				while (isInside(nx, ny) && map[ny][nx] != '*') {
					if (map[ny][nx] == '#' && !visited[ny][nx]) {
						return nc;
					}
					
					if (map[ny][nx] == '!' && !visited[ny][nx]) {
						q.add(new Point(nx, ny, nc, i));
						visited[ny][nx] = true;
					}
					nx += dx[i];
					ny += dy[i];
				}
			}
		}
		return -1;
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
	
	private static class Point {
		int x, y, c, d;
		
		public Point(int x, int y, int c, int d) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.d = d;
		}
	}

}
