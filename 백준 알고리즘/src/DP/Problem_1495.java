package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1495 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] dp = new boolean[N + 1][M + 1];
		
		st = new StringTokenizer(br.readLine());
		dp[0][S] = true;
		
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j <= M; j++) {
				if (dp[i - 1][j]) {
					int plus = j + num;
					if (plus <= M) {
						dp[i][plus] = true;
					}
					
					int minus = j - num;
					if (minus >= 0) {
						dp[i][minus] = true;
					}
				}
			}
		}
		for (int i = M; i >= 0; i--) {
			if (dp[N][i]) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}

}
