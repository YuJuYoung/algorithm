package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_4179 {
	
	private static int R, C;
	private static char[][] maze;
	private static boolean[][] visited;
	private static Point[][] point;
	
	private static Queue<Point> q = new LinkedList<>();
	private static Queue<Point> fire = new LinkedList<>();
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		maze = new char[R][C];
		visited = new boolean[R][C];
		point = new Point[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < C; j++) {
				maze[i][j] = str.charAt(j);
				point[i][j] = new Point(j, i);
				
				if (maze[i][j] == 'J') {
					q.add(point[i][j]);
					visited[i][j] = true;
					maze[i][j] = '.';
				}
				if (maze[i][j] == 'F') {
					fire.add(point[i][j]);
				}
			}
		}
		System.out.println(bfs());
	}
	
	private static String bfs() {
		int time = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			
			fire();
			while (size-- > 0) {
				Point tmp = q.poll();
				int x = tmp.x;
				int y = tmp.y;
				if (x == 0 || x == C - 1 || y == 0 || y == R - 1) {
					return Integer.toString(time);
				}
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (isInside(nx, ny) && maze[ny][nx] == '.' && !visited[ny][nx]) {
						q.add(point[ny][nx]);
						visited[ny][nx] = true;
					}
				}
			}
			time++;
		}
		return "IMPOSSIBLE";
	}
	
	private static void fire() {
		int size = fire.size();
		
		while (size-- > 0) {
			Point tmp = fire.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				
				if (isInside(nx, ny) && maze[ny][nx] == '.') {
					fire.add(point[ny][nx]);
					maze[ny][nx] = 'F';
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
