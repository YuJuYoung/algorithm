package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Problem_2407 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int len = n - m + 1;
		BigInteger[] dp = new BigInteger[len];
		
		dp[0] = new BigInteger("1");
		for (int i = 1; i < len; i++) {
			dp[i] = dp[i - 1].multiply(new BigInteger(n-- + "").divide(new BigInteger(i + "")));
		}
		System.out.print(dp[len - 1]);
	}

}
