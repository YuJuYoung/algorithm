package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem_1525 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String start = "";
		int x = 0, y = 0;
		for (int i = 1; i <= 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= 3; j++) {
				int n = Integer.parseInt(st.nextToken());
				
				if (n == 0) {
					x = j;
					y = i;
					n = 9;
				}
				start += n;
			}
		}
		System.out.println(bfs(new Point(start, x, y)));
	}
	
	private static int bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		Set<String> hs = new HashSet<>();
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, -1, 0, 1 };
		
		q.add(start);
		hs.add(start.n);
		
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				Point p = q.poll();
				if (p.n.equals("123456789")) {
					return time;
				}
				int x = p.x;
				int y = p.y;
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (isOutside(nx, ny)) {
						
					}
				}
			}
			time++;
		}
		return -1;
	}
	
	private static boolean isOutside(int x, int y) {
		return x == -1 || x == 3 || y == -1 || y == 3;
	}
	
	private static class Point {
		String n;
		int x, y;
		
		public Point(String n, int x, int y) {
			this.n = n;
			this.x = x;
			this.y = y;
		}
	}

}
