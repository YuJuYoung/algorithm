package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_13459 {
	
	private static int N, M;
	private static char[][] board;
	private static boolean[][][][] visited;
	private static Point[][] point;
	
	private static Queue<Point[]> q = new LinkedList<>();
	private static int[] dx = { 0, 0, 1, -1 };
	private static int[] dy = { 1, -1, 0, 0 };
	private static int rx, ry, bx, by;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		visited = new boolean[N][M][N][M];
		point = new Point[N][M];
		
		Point[] arr = new Point[2];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j);
				point[i][j] = new Point(j, i);
				
				if (board[i][j] == 'R') {
					arr[0] = point[i][j];
				}
				if (board[i][j] == 'B') {
					arr[1] = point[i][j];
				}
			}
		}
		
		q.add(arr);
		visited[arr[0].y][arr[0].x][arr[1].y][arr[1].x] = true;
		System.out.println(bfs());
	}
	
	private static int bfs() {
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				Point[] arr = q.poll();
				
				for (int i = 0; i < 4; i++) {
					rx = arr[0].x;
					ry = arr[0].y;
					bx = arr[1].x;
					by = arr[1].y;
					
					boolean Rgoal = false;
					boolean Bgoal = false;
					while (moveR(i) || moveB(i)) {
						if (board[by][bx] == 'O') {
							Bgoal = true;
							break;
						}
						if (board[ry][rx] == 'O') {
							Rgoal = true;
						}
					}
					if (Bgoal) {
						continue;
					}
					if (Rgoal) {
						if (board[by + dy[i]][bx + dx[i]] == 'O') {
							continue;
						}
						return 1;
					}
					
					if (visited[ry][rx][by][bx]) {
						continue;
					}
					q.add(new Point[] { point[ry][rx], point[by][bx] });
					visited[ry][rx][by][bx] = true;
				}
			}
			if (++time > 10) {
				break;
			}
		}
		return 0;
	}
	
	private static boolean moveR(int i) {
		int nx = rx + dx[i];
		int ny = ry + dy[i];
		
		if (board[ny][nx] == '#' || (nx == bx && ny == by)) {
			return false;
		}
		rx = nx;
		ry = ny;
		return true;
	}
	
	private static boolean moveB(int i) {
		int nx = bx + dx[i];
		int ny = by + dy[i];
		
		if (board[ny][nx] == '#' || (nx == rx && ny == ry)) {
			return false;
		}
		bx = nx;
		by = ny;
		return true;
	}
	
	private static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
