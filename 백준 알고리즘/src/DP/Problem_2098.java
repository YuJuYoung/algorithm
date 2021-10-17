package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2098 {
	
	private static int N, MAX = 1000000 * 16;
	private static int[] cache;
	private static int[][] arr, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		cache = new int[N + 1];
		arr = new int[N][N];
		dp = new int[N][1 << N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			cache[i] = 1 << i;
		}
		
		cache[N] = (1 << N) - 1;
		System.out.println(dfs(0, 1));
	}
	
	private static int dfs(int current, int visited) {
		if (visited == cache[N]) {
			return arr[current][0] == 0 ? MAX : arr[current][0];
		}
		if (dp[current][visited] != 0) {
			return dp[current][visited];
		}
		
		int min = MAX;
		for (int i = 0; i < N; i++) {
			if ((visited & cache[i]) != 0 || arr[current][i] == 0) {
				continue;
			}
			min = min(min, dfs(i, visited | cache[i]) + arr[current][i]);
		}
		return dp[current][visited] = min;
	}
	
	private static int min(int a, int b) {
		return a > b ? b : a;
	}
}
