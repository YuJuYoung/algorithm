package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2342 {
	
	private static String seq;
	private static int len;
	private static int[][] pows;
	private static int[][][] dp;

	public static void main(String[] args) throws IOException {
		setField();
		System.out.println(solve());
	}
	
	private static void setField() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		if ((seq = br.readLine()).length() == 1) {
			return;
		}
		len = seq.length() / 2;
		pows = new int[5][5];
		dp = new int[len][5][5];
		
		for (int i = 1; i <= 4; i++) {
			pows[0][i] = pows[i][0] = 2;
			pows[i][i] = 1;
		}
		pows[1][2] = pows[2][1] = 3;
		pows[2][3] = pows[3][2] = 3;
		pows[3][4] = pows[4][3] = 3;
		pows[1][4] = pows[4][1] = 3;
		pows[1][3] = pows[3][1] = 4;
		pows[2][4] = pows[4][2] = 4;
	}
	
	private static int solve() {
		if (len == 0) {
			return 0;
		}
		int last, cur;
		
		cur = seq.charAt(0) - 48;
		dp[0][0][cur] = dp[0][cur][0] = 1;
		
		for (int i = 1; i < len; i++) {
			last = seq.charAt((i - 1) * 2) - 48;
			cur = seq.charAt(i * 2) - 48;
			
			
			for (int j = 0; j < 5; j++) {
				int min;
				
				if (dp[i - 1][last][j] != 0) {
					min = Math.min(dp[i][cur][j], dp[i - 1][last][j] + pows[last][cur]);
					dp[i][cur][j] = dp[i][j][cur] = min;
					
					min = Math.min(dp[i][last][cur], dp[i - 1][last][j] + pows[j][cur]);
					dp[i][last][cur] = dp[i][cur][last] = min;
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		int end = seq.charAt((len - 1) * 2) - 48;
		
		for (int i = 0; i < 5; i++) {
			if (min > dp[len - 1][end][i]) {
				min = dp[len - 1][end][i];
			}
		}
		return min;
	}

}
