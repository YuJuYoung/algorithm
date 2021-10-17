package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2579 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] stairs = new int[n + 1];
		int[] dp = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			dp[i] = stairs[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 3; i <= n; i++) {
			dp[i] += Math.max(dp[i - 2], stairs[i - 2] + dp[i - 3]);
		}
		dp[n] = Math.max(dp[n], stairs[n] + dp[n - 1]);
		System.out.println(dp[n]);
	}

}
