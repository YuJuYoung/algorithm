package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_6087 {
	
	private static int W, H;
	private static char[][] map;
	private static boolean[][][] visited;
	
	private static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		visited = new boolean[H][W][2];
		
		for (int i = 0; i < H; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < W; j++) {
				map[i][j] = str.charAt(j);
				
				if (map[i][j] == 'C' && q.isEmpty()) {
					q.add(new Point(j, i, -1));
					visited[i][j][0] = visited[i][j][1] = true;
				}
			}
		}
		System.out.println(bfs());
	}
	
	private static int bfs() {
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				Point p = q.poll();
				int x = p.x;
				int y = p.y;
				int d = p.d;
				
				for (int i = 0; i < 4; i++) {
					int nd = i % 2;
					if (nd == d) {
						continue;
					}
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					while (isInside(nx, ny) && map[ny][nx] != '*' && !visited[ny][nx][nd]) {
						if (map[ny][nx] == 'C') {
							return time;
						}
						q.add(new Point(nx, ny, nd));
						visited[ny][nx][nd] = true;
						
						nx += dx[i];
						ny += dy[i];
					}
				}
			}
			time++;
		}
		return -1;
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < W && y >= 0 && y < H;
	}
	
	private static class Point {
		int x, y, d;
		
		public Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

}
