package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_9252 {
	
	private static int[][] dp;
	private static StringBuilder sb = new StringBuilder();
	private static String a, b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		a = br.readLine();
		b = br.readLine();
		dp = new int[a.length() + 1][b.length() + 1];
		
		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		int len = dp[a.length()][b.length()];
		System.out.println(len + "\n" + search(len, b.length(), a.length()).reverse());
	}
	
	private static StringBuilder search(int count, int x, int y) {
		if (count == 0) {
			return sb;
		}
		if (a.charAt(y - 1) == b.charAt(x - 1)) {
			sb.append(a.charAt(y - 1));
			return search(count - 1, x - 1, y - 1);
		}
		if (dp[y][x - 1] == dp[y][x]) {
			return search(count, x - 1, y);
		}
		return search(count, x, y - 1);
	}

}
