package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_3197 {
	
	private static int R, C, fx, fy;
	private static char[][] map;
	private static Point[][] point;
	
	private static Queue<Point> swan = new LinkedList<>();
	private static Queue<Point> water = new LinkedList<>();
	private static int[] dx = { 0, 0, 1, -1 };
	private static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		point = new Point[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				point[i][j] = new Point(j, i);
				
				if (map[i][j] != 'X') {
					water.add(point[i][j]);
					
					if (map[i][j] == 'L') {
						if (swan.isEmpty()) {
							swan.add(point[i][j]);
						} else {
							fx = j;
							fy = i;
							map[i][j] = '.';
						}
					}
				}
			}
		}
		
		int time = 0;
		while (!spread()) {
			melt();
			time++;
		}
		System.out.println(time);
	}
	
	private static boolean spread() {
		while (!swan.isEmpty()) {
			Point p = swan.poll();
			int x = p.x;
			int y = p.y;
			
			if (dfs(x, y)) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean dfs(int x, int y) {
		map[y][x] = 'L';
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (isInside(nx, ny) && map[ny][nx] == '.') {
				if (nx == fx && ny == fy) {
					return true;
				}
				if (dfs(nx, ny)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static void melt() {
		int size = water.size();
		
		while (size-- > 0) {
			Point p = water.poll();
			int x = p.x;
			int y = p.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (isInside(nx, ny)) {
					if (map[y][x] == '.') {
						if (map[ny][nx] == 'X') {
							water.add(point[ny][nx]);
							map[ny][nx] = '.';
						}
					} else {
						if (map[ny][nx] == 'L') {
							continue;
						}
						
						if (map[ny][nx] == 'X') {
							water.add(point[ny][nx]);
						}
						swan.add(point[ny][nx]);
						map[ny][nx] = 'L';
					}
				}
			}
		}
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < C && y >= 0 && y < R;
	}
	
	private static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
