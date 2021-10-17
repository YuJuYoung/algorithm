package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2146 {
	
	private static Queue q;
	private static int N;
	private static int[][][] map;
	private static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		q = new Queue();
		map = new int[N][N][2];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < N; j++) {
				map[i][j][0] = str.charAt(j * 2) - 48;
			}
		}
		
		int color = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j][0] == 1) {
					dfs(color++, j, i);
				}
			}
		}
		System.out.println(bfs());
	}
	
	private static int bfs() {
		int min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Point tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			int color = tmp.color;
			
			if (map[y][x][1] >= min / 2) {
				return min;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
			    if (isInside(nx, ny)) {
			    	if (map[ny][nx][0] == 0) {
			    		map[ny][nx][0] = color;
			    		map[ny][nx][1] = map[y][x][1] + 1;
			    		q.add(new Point(nx, ny, color));
			    	} else {
			    		if (map[ny][nx][0] != color) {
			    			int len = map[ny][nx][1] + map[y][x][1];
			    			
			    			if (min > len) {
			    				min = len;
			    			}
			    		}
			    	}
			    }
			}
		}
		return min;
	}
	
	private static void dfs(int color, int x, int y) {
		map[y][x][0] = color;
		q.add(new Point(x, y, color));
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (isInside(nx, ny) && map[ny][nx][0] == 1) {
				dfs(color, nx, ny);
			}
		}
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
	
	private static class Point {
		int x, y;
		int color;
		
		public Point(int x, int y, int color) {
			this.x = x;
			this.y = y;
			this.color = color;
		}
	}
	
	private static class Queue {
		Point[] q = new Point[N * N];
		int f = -1, r = -1;
		
		public void add(Point p) {
			q[++f] = p;
		}
		
		public Point poll() {
			return q[++r];
		}
		
		public boolean isEmpty() {
			return f == r;
		}
	}

}
