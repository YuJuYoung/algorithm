package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2491 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[][] dp = new int[2][N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		
		int max = dp[0][0] = dp[1][0] = 1;
		for (int i = 1; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if (arr[i] > arr[i - 1]) {
				dp[0][i] = dp[0][i - 1] + 1;
				dp[1][i] = 1;
			} else if (arr[i] < arr[i - 1]) {
				dp[1][i] = dp[1][i - 1] + 1;
				dp[0][i] = 1;
			} else {
				dp[1][i] = dp[1][i - 1] + 1;
				dp[0][i] = dp[0][i - 1] + 1;
			}
			max = Math.max(max, dp[0][i]);
			max = Math.max(max, dp[1][i]);
		}
		System.out.println(max);
	}

}
