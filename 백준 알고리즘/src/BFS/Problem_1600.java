package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1600 {
	
	private static int K, W, H;
	private static char[][] map;
	private static int[][] visited;
	private static Queue q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		q = new Queue(W, H, K);
		map = new char[H][W];
		visited = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < W; j++) {
				map[i][j] = str.charAt(j * 2);
				visited[i][j] = K + 1;
			}
		}
		System.out.println(bfs());
	}
	
	private static int bfs() {
		int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1, 1, -1, 0, 0 };
		int[] dy = { 2, 1, -1, -2, -2, -1, 1, 2, 0, 0, 1, -1 };
		add(0, 0, 0, 0);
		
		while (!q.isEmpty()) {
			Point tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			int time = tmp.time;
			if (x == W - 1 && y == H - 1) {
				return time;
			}
			int count = tmp.count;
			
			for (int i = 8; i < 12; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (isInside(nx, ny) && map[ny][nx] != '1' && visited[ny][nx] > count) {
					add(nx, ny, time + 1, count);
				}
			}
			
			if (count == K) {
				continue;
			}
			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (isInside(nx, ny) && map[ny][nx] != '1' && visited[ny][nx] > count + 1) {
					add(nx, ny, time + 1, count + 1);
				}
			}
		}
		return -1;
	}
	
	private static void add(int x, int y, int time, int count) {
		q.add(new Point(x, y, time, count));
		visited[y][x] = count;
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < W && y >= 0 && y < H;
	}
	
	private static class Point {
		int x, y;
		int time;
		int count;
		
		public Point(int x, int y, int time, int count) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.count = count;
		}
	}
	
	private static class Queue {
		Point[] q;
		int f = -1, r = -1;
		
		public Queue(int W, int H, int K) {
			q = new Point[W * H * K];
		}
		
		public Point poll() {
			return q[++r];
		}
		
		public boolean isEmpty() {
			return f == r;
		}
		
		public void add(Point p) {
			q[++f] = p;
		}
	}

}
