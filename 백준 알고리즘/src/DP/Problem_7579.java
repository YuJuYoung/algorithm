package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_7579 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] m = new int[N];
		int[] c = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sum += c[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[sum + 1];
		for (int i = 0; i < N; i++) {
			for (int j = sum; j >= c[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - c[i]] + m[i]);
			}
		}
		
		int answer = 0;
		for (int i = 0; i <= sum; i++) {
			if (dp[i] >= M) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}

}
