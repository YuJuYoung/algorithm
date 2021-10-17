package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_16954 {
	
	private static char[][] board = new char[9][8];
	private static boolean[][] visited = new boolean[8][8];
	private static Point[][] point = new Point[8][8];
	
	private static int[] dx = { 1, 1, 1, 0, -1, -1, -1, 0 };
	private static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 8; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < 8; j++) {
				board[i][j] = str.charAt(j);
				point[i][j] = new Point(j, i);
			}
		}
		System.out.println(bfs());
	}
	
	private static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(point[7][0]);
		visited[7][0] = true;
		
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				Point p = q.poll();
				int x = p.x;
				int y = p.y;
				
				if (board[y][x] == '#') {
					continue;
				}
				for (int i = 0; i < 8; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (isInside(nx, ny) && board[ny][nx] == '.' && !visited[ny][nx]) {
						if (nx == 7 && ny == 0) {
							return 1;
						}
						q.add(point[ny][nx]);
						visited[ny][nx] = true;
					}
				}
				q.add(p);
			}
			if (++time > 8) {
				return 1;
			}
			downBlock();
		}
		return 0;
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < 8 && y >= 0 && y < 8;
	}
	
	private static void downBlock() {
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] == '#') {
					board[i + 1][j] = '#';
					board[i][j] = '.';
					visited[i][j] = false;
				}
			}
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
