package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11060 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.println(0);
			return;
		}
		int[] A = new int[N];
		int[] dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 1;
		for (int i = 0; i < N - 1; i++) {
			if (dp[i] == 0) {
				continue;
			}
			for (int j = i + 1; j < N && j <= i + A[i]; j++) {
				if (dp[j] == 0) {
					dp[j] = dp[i] + 1;
				} else {
					dp[j] = Math.min(dp[j], dp[i] + 1);
				}
			}
		}
		System.out.println(dp[N - 1] == 0 ? -1 : dp[N - 1] - 1);
	}

}
