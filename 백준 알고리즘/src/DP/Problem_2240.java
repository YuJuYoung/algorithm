package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2240 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] dp = new int[T + 1][W + 2];
		
		for (int i = 1; i <= T; i++) {
			String num = br.readLine();
			
			for (int j = 1; j <= W + 1 && j <= i * 2; j++) {
				dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]);
				
				if (check(num, j)) {
					dp[i][j]++;
				}
			}
		}
		
		int max = dp[T][1];
		for (int i = 2; i <= W + 1; i++) {
			if (max < dp[T][i]) {
				max = dp[T][i];
			}
		}
		System.out.println(max);
	}
	
	private static int max(int a, int b) {
		return a > b ? a : b;
	}
	
	private static boolean check(String num, int j) {
		return (num.equals("1") && j % 2 == 1) || (num.equals("2") && j % 2 == 0);
	}

}
