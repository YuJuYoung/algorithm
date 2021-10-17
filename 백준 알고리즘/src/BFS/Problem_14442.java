package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_14442 {
	
	private static int N, M, K;
	private static char[][] map;
	private static int[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		System.out.println(bfs());
	}
	
	private static int bfs() {
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 1, K));
		visited[0][0] = K;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.x == M - 1 && p.y == N - 1) {
				return p.t;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				// 부술 수 있는 벽의 개수가 이전의 경우보다 많아야 한다.
				if (isInside(nx, ny) && visited[ny][nx] <= p.c) {
					if (map[ny][nx] == '1') {
						q.add(new Point(nx, ny, p.t + 1, p.c - 1));
					} else {
						q.add(new Point(nx, ny, p.t + 1, p.c));
					}
					visited[ny][nx] = p.c;
				}
			}
		}
		return -1;
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < M && y >= 0 && y < N;
	}
	
	private static class Point {
		int x, y, t, c;
		
		public Point(int x, int y, int t, int c) {
			this.x = x;
			this.y = y;
			this.t = t;
			this.c = c;
		}
	}

}
