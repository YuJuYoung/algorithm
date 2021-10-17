package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1256 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//2 2 2 N M K
		
		String temp = reader.readLine();
		
		StringTokenizer stk = new StringTokenizer(temp);
		
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		
		long K = (long)Integer.parseInt(stk.nextToken());
		
		
		int n = N + M;
		
		long[][] dp = new long[n + 1][M + 1];
		
		dp[0][0] = 1;
		
		for (int i = 1; i <= n; i++) {
			dp[i][0] = 1;
			
			for (int j = 1; j <= M; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i - 1][j-1];
			}
		}
		
		if (dp[n][M] < 0 || dp[n][M] >= K) {
			
			StringBuffer buff = new StringBuffer();
			for (int i = 1; i <= n; i++) {

				if (dp[n - i][M] >= K || dp[n - i][M] < 0) {
					buff.append('a');
				} else{
					
					buff.append('z');
					K -= dp[n - i][M];
					M--; // z를 골랐으니 nCk 의 k를 줄여야 함
					
				}
				
			}
			
			System.out.println(buff.toString());
			System.out.println(dp[200][100]);
		} else {
			System.out.println("-1");
		}
		
		
		
		
		
	}
}