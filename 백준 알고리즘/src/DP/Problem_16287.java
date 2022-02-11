package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_16287 {
	
	private static int w, n;
	private static int[] A;
	private static boolean[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		w = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		A = new int[n];
		dp = new boolean[w + 1][5];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		dp[0][0] = true;
		
		for (int i = 0; i < n; i++) {
			int weight = A[i];
			
			for (int j = Math.min(w, getMax(i) + weight); j - weight >= 0; j--) {
				for (int k = 0; k <= 3; k++) {
					if (dp[j - weight][k]) {
						dp[j][k + 1] = true;
					}
				}
			}
		}
		System.out.println(dp[w][4] ? "YES" : "NO");
	}
	
	private static int getMax(int i) {
		if (i == 0) {
			return 0;
		}
		if (i == 1) {
			return A[0];
		}
		if (i == 2) {
			return A[0] + A[1];
		}
		return A[i - 3] + A[i - 2] + A[i - 1];
	}

}
