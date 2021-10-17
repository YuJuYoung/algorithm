package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2670 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		double[] dp = new double[N];
		
		double max = dp[0] = Double.parseDouble(br.readLine());
		for (int i = 1; i < N; i++) {
			dp[i] = Double.parseDouble(br.readLine());
			dp[i] = Math.max(dp[i - 1] * dp[i], dp[i]);
			
			if (max < dp[i]) {
				max = dp[i];
			}
		}
		System.out.printf("%.3f", max);
	}

}
