package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1103 {
	
	private static int N, M, ans = -1;
	private static int[][] board, cache;
	private static boolean[][] visited;
	
	private static int[] dx = { 0, -1, 1, 0 };
	private static int[] dy = { 1, 0, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		cache = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}
		
		cache[0][0] = 0;
		System.out.println(dfs(0, 0, 1) ? -1 : ans);
	}
	
	private static boolean dfs(int x, int y, int c) {
		if (visited[y][x]) {
			return true;
		}
		if (cache[y][x] != 0) {
			return false;
		}
		visited[y][x] = true;
		cache[y][x] = c;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i] * board[y][x];
			int ny = y + dy[i] * board[y][x];
			
			if (isEnd(nx, ny)) {
				if (ans < c) {
					ans = c;
				}
			} else {
				if (dfs(nx, ny, c + 1)) {
					return true;
				}
			}
		}
		visited[y][x] = false;
		return false;
	}
	
	private static boolean isEnd(int x, int y) {
		return x < 0 || x >= M || y < 0 || y >= N || board[y][x] > 9;
	}

}
