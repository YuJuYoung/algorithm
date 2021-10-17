package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		String b = br.readLine();
		System.out.println(solve(" " + a, " " + b));
	}
	
	private static int solve(String a, String b) {
		int aLen = a.length() - 1;
		int bLen = b.length() - 1;
		int[][] dp = new int[aLen + 1][bLen + 1];
		
		for (int i = 1; i <= aLen; i++) {
			for (int j = 1; j <= bLen; j++) {
				
				if (a.charAt(i) == b.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[aLen][bLen];
	}

}
