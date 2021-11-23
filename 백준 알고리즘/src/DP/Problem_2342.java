package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2342 {
	
	private static int len;
	private static int[] arr;
	private static int[][] pows;
	private static int[][][] dp;

	public static void main(String[] args) throws IOException {
		setField();
		System.out.println(solve());
	}
	
	private static void setField() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String seq = br.readLine();
		
		if (seq.length() == 1) {
			return;
		}
		len = seq.length() / 2;
		arr = new int[len];
		pows = new int[5][5];
		dp = new int[len][5][5];
		
		for (int i = 0; i < len; i++) {
			arr[i] = seq.charAt(i * 2) - 48;
		}
		
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
		dp[0][0][arr[0]] = dp[0][arr[0]][0] = 2;
		
		for (int i = 1; i < len; i++) {
			int last = arr[i - 1];
			int cur = arr[i];
			
			for (int j = 0; j < 5; j++) {
				if (dp[i - 1][last][j] == 0) {
					continue;
				}
				
				int left = dp[i - 1][last][j] + pows[last][cur];
				
				if (dp[i][cur][j] != 0) {
					left = Math.min(dp[i][cur][j], left);
				}
				dp[i][cur][j] = dp[i][j][cur] = left;
				
				int right = dp[i - 1][last][j] + pows[j][cur];
				
				if (dp[i][last][cur] != 0) {
					right = Math.min(dp[i][last][cur], right);
				}
				dp[i][last][cur] = dp[i][cur][last] = right;
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < 5; i++) {
			int num = dp[len - 1][arr[len - 1]][i];
			
			if (num == 0) {
				continue;
			}
			min = Math.min(min, num);
		}
		return min;
	}

}
