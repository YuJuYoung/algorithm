package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2156 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			dp[i] = arr[i] = Integer.parseInt(br.readLine());
		}
		if (n > 1) {
			dp[2] += dp[1];
		}
		for (int i = 3; i <= n; i++) {
			dp[i] += Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]);
			dp[i] = Math.max(dp[i - 1], dp[i]);
		}
		System.out.println(dp[n]);
	}

}
