package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11055 {
	
	private static int[] dp, arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		dp = new int[N];
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for (int i = N - 1; i >= 0; i--) {
			max = max(max, dfs(i));
		}
		System.out.println(max);
	}
	
	private static int dfs(int index) {
		if (dp[index] != 0) {
			return dp[index];
		}
		
		int max = 0;
		for (int i = index - 1; i >= 0; i--) {
			if (arr[i] < arr[index]) {
				max = max(max, dfs(i));
			}
		}
		return dp[index] = arr[index] + max;
	}
	
	private static int max(int a, int b) {
		return a > b ? a : b;
	}

}
