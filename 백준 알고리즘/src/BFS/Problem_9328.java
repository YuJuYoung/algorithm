package BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_9328 {
	
	private static int h, w, count;
	private static boolean[] key;
	private static char[][] map;
	
	private static Queue<Point> q;
	private static Queue<Point> door;
	private static int[] dx = { 0, 1, -1, 0 };
	private static int[] dy = { 1, 0, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				
				for (int j = 0; j < w; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			key = new boolean[26];
			
			String str = br.readLine();
			if (str.charAt(0) != '0') {
				for (int i = 0; i < str.length(); i++) {
					key[str.charAt(i) - 97] = true;
				}
			}
			
			q = new LinkedList<>();
			for (int i = 0; i < h; i++) {
				q.add(new Point(-1, i));
				q.add(new Point(w, i));
			}
			for (int i = 0; i < w; i++) {
				q.add(new Point(i, -1));
				q.add(new Point(i, h));
			}
			
			count = 0;
			door = new LinkedList<>();
			
			while (!q.isEmpty()) {
				while (!q.isEmpty()) {
					Point p = q.poll();
					dfs(p.x, p.y);
				}
				int size = door.size();
				
				while (size-- > 0) {
					Point p = door.poll();
					int x = p.x;
					int y = p.y;
					
					if (map[y][x] != '*' && key[map[y][x] - 65]) {
						map[y][x] = '*';
						q.add(p);
					} else {
						door.add(p);
					}
				}
			}
			bw.write(count + "\n");
		}
		bw.close();
	}
	
	private static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (isInside(nx, ny) && map[ny][nx] != '*') {
				char c = map[ny][nx];
				
				if (c == '$') {
					count++;
				} else if (c >= 'a' && c <= 'z') {
					key[c - 97] = true;
				} else if (c >= 'A' && c <= 'Z') {
					door.add(new Point(nx ,ny));
					continue;
				}
				map[ny][nx] = '*';
				dfs(nx, ny);
			}
		}
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && y < h && x < w && y >= 0;
	}
	
	private static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
