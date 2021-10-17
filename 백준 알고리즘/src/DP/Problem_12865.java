package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][2];
		int[] dp = new int[K + 1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			for (int j = K; j >= arr[i][0]; j--) {
				dp[j] = Math.max(dp[j], dp[j - arr[i][0]] + arr[i][1]);
			}
		}
		System.out.println(dp[K]);
	}

}
