package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_2629 {
	
	private static int SIZE = 0;
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			SIZE += arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[SIZE + 1];
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = SIZE; j >= arr[i]; j--) {
				dp[j] += dp[j - arr[i]];
			}
		}
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		while (m-- > 0) {
			bw.write(isPossible(Integer.parseInt(st.nextToken())) ? "Y " : "N ");
		}
		bw.close();
	}
	
	private static boolean isPossible(int num) {
		if (num > SIZE) {
			return false;
		}
		if (dp[num] > 0) {
			return true;
		}
		for (int i = 0; i + num <= SIZE; i++) {
			if (dp[i] > 0 && dp[i + num] > 0) {
				if (dp[i] == 1 && dp[i + num] == 1 && dp[num] > 0) {
					continue;
				}
				return true;
			}
		}
		return false;
	}

}
