package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_10835 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N + 1];
		int[] B = new int[N + 1];
		int[][] dp = new int[N + 1][N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = N; i > 0; i--) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = N; i > 0; i--) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (A[i] > B[j]) {
					dp[i][j] = B[j] + dp[i][j - 1];
				} else {
					dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1]);
				}
			}
		}
		System.out.println(dp[N][N]);
	}
	
	private static int max(int a, int b) {
		return a > b ? a : b;
	}

}
