package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1328 {
	
	private static final long MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		long[][][] dp = new long[N + 1][N + 1][N + 1];
		
		dp[1][1][1] = 1;
		for (int n = 2; n <= N; n++) {
			for (int l = 1; l <= n; l++) {
				for (int r = 1; l + r <= n + 1; r++) {
					dp[n][l][r] = (dp[n - 1][l - 1][r] + dp[n - 1][l][r - 1] + dp[n - 1][l][r] * (n - 2)) % MOD;
				}
			}
		}
		System.out.println(dp[N][L][R]);
	}

}
