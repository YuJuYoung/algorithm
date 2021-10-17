package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_13460 {
	
	private static final char WALL = '#', GOAL = 'O';
	
	private static char[][] map;
	private static boolean[][][][] visited;
	
	private static int rx, ry, bx, by;
	private static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				
				if (map[i][j] == 'R') {
					rx = j;
					ry = i;
				}
				if (map[i][j] == 'B') {
					bx = j;
					by = i;
				}
			}
		}
		visited[ry][rx][by][bx] = true;
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(rx, ry, bx, by, 1));
		System.out.println(bfs(q));
	}
	
	private static int bfs(Queue<Point> q) {
		while (!q.isEmpty()) {
			Point tmp = q.poll();
			
			for (int i = 0; i < 4; i++) {
				rx = tmp.rx;
				ry = tmp.ry;
				bx = tmp.bx;
				by = tmp.by;
				int c = tmp.c;
				
				boolean blueGoaled = false;
				boolean redGoaled = false;
				
				while (moveBlue(i) || moveRed(i)) {
					if (map[by][bx] == GOAL) {
						blueGoaled = true;
						break;
					}
					if (map[ry][rx] == GOAL) {
						redGoaled = true;
					}
				}
				
				if (blueGoaled) {
					continue;
				}
				if (redGoaled) {
					if (map[by + dy[i]][bx + dx[i]] == GOAL) {
						continue;
					}
					return c;
				}
				
				if (c == 10 || visited[ry][rx][by][bx]) {
					continue;
				}
				visited[ry][rx][by][bx] = true;
				q.add(new Point(rx, ry, bx, by, c + 1));
			}
		}
		return -1;
	}
	
	private static boolean moveRed(int i) {
		int nx = rx + dx[i];
		int ny = ry + dy[i];
		
		if (map[ny][nx] == WALL || (nx == bx && ny == by)) {
			return false;
		}
		rx = nx;
		ry = ny;
		return true;
	}
	
	private static boolean moveBlue(int i) {
		int nx = bx + dx[i];
		int ny = by + dy[i];
		
		if (map[ny][nx] == WALL || (nx == rx && ny == ry)) {
			return false;
		}
		bx = nx;
		by = ny;
		return true;
	}
	
	private static class Point {
		int rx, ry, bx, by, c;
		
		public Point(int rx, int ry, int bx, int by, int c) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.c = c;
		}
	}

}
