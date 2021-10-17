package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1699 {
	
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		System.out.println(solve(N));
	}
	
	private static int solve(int N) {
		if (dp[N] != 0) {
			return dp[N];
		}
		
		int min = N;
		for (int i = 2; i * i <= N; i++) {
			int temp = N / (i * i) + solve(N % (i * i));
			if (min > temp) {
				min = temp;
			}
		}
		return dp[N] = min;
	}

}
