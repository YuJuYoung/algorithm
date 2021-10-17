package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_14226 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int S = Integer.parseInt(br.readLine());
		int[] dp = new int[S + 1];
		Arrays.fill(dp, 1234);
		
		dp[1] = 0;
		for (int i = 1; i <= S / 2; i++) {
			int next = i * 2;
			if (next <= S) {
				int temp = dp[i] + 2;
				
				for (int j = next; j <= S; j += i) {
					dp[j] = min(dp[j], temp++);
					
					int k = j;
					int l = dp[j] + 1;
					while (k-- > 0) {
						if (dp[k] <= l) {
							break;
						}
						dp[k] = l;
					}
				}
			}
		}
		System.out.println(dp[S]);
	}
	
	private static int min(int a, int b) {
		return a < b ? a : b;
	}

}