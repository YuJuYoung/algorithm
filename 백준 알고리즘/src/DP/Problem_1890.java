package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1890 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		long[][] dp = new long[N][N];
		
		for (int i = 0; i < N; i++) {
			char[] chars = br.readLine().toCharArray();
			
			for (int j = 0; j < N; j++) {
				board[i][j] = chars[j * 2] - '0';
			}
		}
		
		dp[0][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0) {
					continue;
				}
				
				int ni = i + board[i][j];
				int nj = j + board[i][j];
				if (ni < N) {
					dp[ni][j] += dp[i][j];
				}
				if (nj < N) {
					dp[i][nj] += dp[i][j];
				}
			}
		}
		System.out.println(dp[N - 1][N - 1]);
	}

}
