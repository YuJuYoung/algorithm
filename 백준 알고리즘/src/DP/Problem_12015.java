package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_12015 {
	
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		dp[0] = Integer.parseInt(st.nextToken());
		
		int len = 0;
		while (N-- > 1) {
			int num = Integer.parseInt(st.nextToken());
			
			if (dp[len] < num) {
				dp[++len] = num;
			} else {
				dp[binarySearch(0, len, num)] = num;
			}
		}
		System.out.println(len + 1);
	}
	
	private static int binarySearch(int s, int e, int num) {
		while (s < e) {
			int mid = (s + e) / 2;
			
			if (num > dp[mid]) {
				s = mid + 1;
			} else {
				e = mid;
			}
		}
		return e;
	}

}
