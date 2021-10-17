package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_15988 {
	
	private static final int SIZE = 1000001, MOD =  1000000009;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long[] dp = new long[SIZE];
		
		dp[0] = dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < SIZE; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
		}
		
		for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
			bw.write(dp[Integer.parseInt(br.readLine())] + "\n");
		}
		bw.close();
	}

}
