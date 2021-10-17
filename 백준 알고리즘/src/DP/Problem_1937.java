package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1937 {
	
	private static int n;
	private static int[][] forest, dp;
	private static int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		forest = new int[n][n];
		dp = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				forest[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (dp[i][j] == 0) {
					dp[i][j] = dfs(j, i);
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max);
	}
	
	private static int dfs(int x, int y) {
		int max = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (isInside(nx, ny) && forest[ny][nx] > forest[y][x]) {
				if (dp[ny][nx] == 0) {
					dp[ny][nx] = dfs(nx, ny);
				}
				max = Math.max(max, dp[ny][nx]);
			}
		}
		return max + 1;
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

}
