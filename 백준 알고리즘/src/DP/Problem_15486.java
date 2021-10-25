package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_15486 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		
		for (int i = 0; i < N; i++) {
			String[] arr = br.readLine().split(" ");
			
			int t = Integer.parseInt(arr[0]);
			int p = Integer.parseInt(arr[1]);
			int nextT = i + t;
			
			if (nextT <= N) {
				dp[nextT] = Math.max(dp[nextT], dp[i] + p);
			}
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		System.out.println(dp[N]);
	}

}
