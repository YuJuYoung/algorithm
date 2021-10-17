package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2011 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] chars = br.readLine().toCharArray();
		if (chars.length == 0 || chars[0] == '0') {
			System.out.println(0);
			return;
		}
		int len = chars.length;
		int[] dp = new int[len + 1];
		
		for (int i = 0; i < len; i++) {
			chars[i] -= 48;
		}
		
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= len; i++) {
			int a = chars[i - 1];
			int b = chars[i - 2] * 10 + a;
			
			if (a == 0 && b > 26) {
				break;
			}
			if (a > 0) {
				dp[i] = dp[i - 1];
			}
			if (b >= 10 && b <= 26) {
				dp[i] = (dp[i] + dp[i - 2]) % 1000000;
			}
		}
		System.out.println(dp[len]);
    }

}
