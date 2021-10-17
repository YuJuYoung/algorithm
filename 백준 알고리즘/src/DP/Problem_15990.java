package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_15990 {
	
	private static final long MOD = 1000000009;
	private static final int SIZE = 100001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long[][] dp = new long[SIZE][3];
		dp[1][0] = dp[2][1] = dp[3][2] = dp[3][1] = dp[3][0] = 1;
		for (int i = 4; i < SIZE; i++) {
			dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % MOD;
			dp[i][1] = (dp[i - 2][0] + dp[i - 2][2]) % MOD;
			dp[i][2] = (dp[i - 3][0] + dp[i - 3][1]) % MOD;
		}
		for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
			int num = Integer.parseInt(br.readLine());
			bw.write(((dp[num][0] + dp[num][1] + dp[num][2]) % MOD) + "\n");
		}
		bw.close();
	}

}
