package BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_5427 {
	
	private static int w, h;
	private static char[][] map;
	private static boolean[][] visited;
	private static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
	private static Queue<Point> q, fire;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			visited = new boolean[h][w];
			
			q = new LinkedList<>();
			fire = new LinkedList<>();
			
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
						
				for (int j = 0; j < w; j++) {
					map[i][j] = str.charAt(j);
					
					if (map[i][j] == '@') {
						q.add(new Point(j, i));
						visited[i][j] = true;
						map[i][j] = '.';
					}
					if (map[i][j] == '*') {
						fire.add(new Point(j, i));
					}
				}
			}
			bw.write(bfs());
		}
		bw.close();
	}
	
	private static String bfs() {
		int time = 0;
		while (!q.isEmpty()) {
			spread();
			int size = q.size();
			
			while (size-- > 0) {
				Point tmp = q.poll();
				int x = tmp.x;
				int y = tmp.y;
				
				if (x == 0 || y == 0 || x == w - 1 || y == h - 1) {
					return time + 1 + "\n";
				}
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (map[ny][nx] == '.' && !visited[ny][nx]) {
						q.add(new Point(nx, ny));
						visited[ny][nx] = true;
					}
				}
			}
			time++;
		}
		return "IMPOSSIBLE\n";
	}
	
	private static void spread() {
		int size = fire.size();
		
		while (size-- > 0) {
			Point tmp = fire.poll();
			int x = tmp.x;
			int y = tmp.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (isInside(nx, ny) && map[ny][nx] == '.') {
					fire.add(new Point(nx, ny));
					map[ny][nx] = '*';
				}
			}
		}
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < w && y >= 0 && y < h;
	}
	
	private static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
