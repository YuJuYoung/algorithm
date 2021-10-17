package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_5557 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N][21];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		dp[1][Integer.parseInt(st.nextToken())] = 1;
		for (int i = 2; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j <= 20; j++) {
				if (dp[i - 1][j] > 0) {
					int plus = j + num;
					int minus = j - num;
					
					if (plus <= 20) {
						dp[i][plus] += dp[i - 1][j];
					}
					if (minus >= 0) {
						dp[i][minus] += dp[i - 1][j];
					}
				}
			}
		}
		System.out.println(dp[N - 1][Integer.parseInt(st.nextToken())]);
	}

}
