package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_10164 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N + 1][M + 1];
		dp[0][1] = 1;
		
		int x = 1, y = 1;
		if(K != 0) {
			x = (K - 1) % M + 1;
			y = (K - 1) / M + 1;
			
			for (int i = 1; i <= y; i++) {
				for (int j = 1; j <= x; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		for (int i = y; i <= N; i++) {
			for (int j = x; j <= M; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		System.out.println(dp[N][M]);
	}

}
