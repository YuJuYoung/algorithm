package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1577 {
	
	private static int N, M;
	
	private static long[][] dp;
	private static boolean[][][] stop;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dp = new long[N + 1][M + 1];
		stop = new boolean[N + 1][M + 1][2];
		
		for (int K = Integer.parseInt(br.readLine()); K > 0; K--) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			if (a < c) {
				stop[c][d][0] = true;
			} else if (a > c) {
				stop[a][b][0] = true;
			} else if (b < d) {
				stop[c][d][1] = true;
			} else {
				stop[a][b][1] = true;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (stop[i][0][0]) {
				break;
			}
			dp[i][0] = 1;
		}
		for (int i = 1; i <= M; i++) {
			if (stop[0][i][1]) {
				break;
			}
			dp[0][i] = 1;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (!stop[i][j][0]) {
					dp[i][j] = dp[i - 1][j];
				}
				if (!stop[i][j][1]) {
					dp[i][j] += dp[i][j - 1];
				}
			}
		}
		System.out.println(dp[N][M]);
	}
}
