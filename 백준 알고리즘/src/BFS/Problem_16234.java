package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_16234 {
	
	private static int N, L, R;
	private static int[][] A;
	private static boolean[][] visited;
	
	private static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
	private static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		while (true) {
			boolean flag = false;
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = i % 2; j < N; j += 2) {
					if (!visited[i][j]) {
						int sum = dfs(j, i);
						
						if (sum == A[i][j]) {
							q.poll();
							continue;
						}
						int n = sum / q.size();
						Point temp = null;
						
						while ((temp = q.poll()) != null) {
							A[temp.y][temp.x] = n;
						}
						flag = true;
					}
				}
			}
			if (!flag) {
				break;
			}
			answer++;
		}
		System.out.print(answer);
	}
	
	private static int dfs(int x, int y) {
		q.add(new Point(x, y));
		visited[y][x] = true;
		int sum = A[y][x];
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (isInside(nx, ny) && !visited[ny][nx]) {
				int n = Math.abs(A[ny][nx] - A[y][x]);
				
				if (n >= L && n <= R) {
					sum += dfs(nx, ny);
				}
			}
		}
		return sum;
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
	
	private static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
