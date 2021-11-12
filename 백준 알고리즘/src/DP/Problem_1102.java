package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1102 {
	
	private static int N, P;
	private static int[] dp;
	private static int[][] costs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dp = new int[1 << N];
		costs = new int[N][N];
		
		for (int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				costs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.fill(dp, -1);
		
		String str = br.readLine();
		int bit = 0, cnt = 0;
		
		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == 'Y') {
				bit += 1 << i;
				cnt++;
			}
		}
		
		P = Integer.parseInt(br.readLine());
		int result = dfs(bit, cnt);
		
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}
	
	private static int dfs(int bit, int cnt) {
		if (cnt >= P) {
			return 0;
		}
		if (dp[bit] != -1) {
			return dp[bit];
		}
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			int nextBit = bit | (1 << i);
			
			if (nextBit == bit) {
				continue;
			}
			for (int j = 0; j < N; j++) {
				if ((bit | (1 << j)) == bit) {
					int next = dfs(nextBit, cnt + 1);
					
					if (next != Integer.MAX_VALUE) {
						min = Math.min(min, next + costs[j][i]);
					}
				}
			}
		}
		return dp[bit] = min;
	}
}
