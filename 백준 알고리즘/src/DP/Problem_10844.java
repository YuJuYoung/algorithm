package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10844 {
	
	private static final int MOD = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][11];
		
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i <= N; i++) {
			 dp[i][0] = dp[i - 1][1];
			 
			 for (int j = 1; j <= 9; j++) {
				 dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
			 }
		}
		
		int sum = 0;
		for (int i = 0; i <= 9; i++) {
			sum = (sum + dp[N][i]) % MOD;
		}
		System.out.println(sum);
	}

}
