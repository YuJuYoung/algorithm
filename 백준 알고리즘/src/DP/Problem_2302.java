package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2302 {
	
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		
		int answer = 1;
		int last = 0;
		while (M-- > 0) {
			int num = Integer.parseInt(br.readLine());
			answer *= search(num - last - 1);
			last = num;
		}
		System.out.println(answer * search(N - last));
	}
	
	private static int search(int n) {
		if (dp[n] != 0) {
			return dp[n];
		}
		if (n == 0 || n == 1) {
			return 1;
		}
		return dp[n] = search(n - 1) + search(n - 2);
	}

}
