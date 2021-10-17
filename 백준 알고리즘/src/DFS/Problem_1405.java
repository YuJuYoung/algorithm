package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1405 {
	
	private static int N;
	private static double answer = 0.0;
	private static boolean[][] visited;
	
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };
	private static double[] arr = new double[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		visited = new boolean[N * 2 + 1][N * 2 + 1];
		
		for (int i = 0; i < 4; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) / 100.0;
		}
		
		dfs(N, N, 0, 1.0);
		System.out.println(answer);
	}
	
	private static void dfs(int x, int y, int c, double n) {
		if (c == N) {
			answer += n;
		} else {
			visited[y][x] = true;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (!visited[ny][nx]) {
					dfs(nx, ny, c + 1, n * arr[i]);
				}
			}
			visited[y][x] = false;
		}
	}

}
