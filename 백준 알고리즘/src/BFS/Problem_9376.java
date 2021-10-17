package BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Problem_9376 {
	
	private static int h, w;
	private static char[][] map;
	private static int[][][] cache;
	
	private static int[] dx = { 0, -1, 0, 1 };
	private static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			h = Integer.parseInt(st.nextToken()) + 2;
			w = Integer.parseInt(st.nextToken()) + 2;
			map = new char[h][w];
			cache = new int[h][w][3];
			
			Point[] start = new Point[3];
			int idx = 1;
			for (int i = 1; i < h - 1; i++) {
				String str = br.readLine();
				
				for (int j = 1; j < w - 1; j++) {
					map[i][j] = str.charAt(j - 1);
					
					if (map[i][j] == '$') {
						start[idx++] = new Point(j, i, 0);
					}
				}
			}
			start[0] = new Point(0, 0, 0);
			
			for (int i = 0; i < 3; i++) {
				bfs(start[i], i);
			}
			
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == '*') {
						continue;
					}
					int sum = cache[i][j][0] + cache[i][j][1] + cache[i][j][2];
					
					if (map[i][j] == '#') {
						sum -= 2;
					}
					ans = Math.min(ans, sum);
				}
			}
			bw.write(ans + "\n");
		}
		bw.close();
	}
	
	private static void bfs(Point start, int idx) {
		boolean[][] visited = new boolean[h][w];
		
		ArrayDeque<Point> q = new ArrayDeque<>();
		q.add(start);
		visited[start.y][start.x] = true;
		
		while (!q.isEmpty()) {
			Point p = q.pollFirst();
			int x = p.x;
			int y = p.y;
			int c = p.c;
			cache[y][x][idx] = c;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (isInside(nx, ny) && map[ny][nx] != '*' && !visited[ny][nx]) {
					if (map[ny][nx] == '#') {
						q.addLast(new Point(nx, ny, c + 1));
					} else {
						q.addFirst(new Point(nx, ny, c));
					}
					visited[ny][nx] = true;
				}
			}
		}
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < w && y >= 0 && y < h;
	}
	
	private static class Point {
		int x, y, c;
		
		public Point(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

}
