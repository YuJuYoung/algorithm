package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_16287 {
	
	private static int w, n;
	
	private static int[] A;
	private static boolean[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		w = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		A = new int[n];
		dp = new boolean[w + 1][4];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		System.out.println(dfs(-1, 0, 0) ? "YES" : "NO");
	}
	
	private static boolean dfs(int last, int sum, int cnt) {
		dp[sum][cnt] = true;
		
		for (int i = last + 1; i <= n - 4 + cnt; i++) {
			int nSum = sum + A[i];
			
			if (nSum > w) {
				break;
			}
			
			if (cnt == 3) {
				if (nSum == w) {
					return true;
				}
				return false;
			} else {
				if (!dp[nSum][cnt + 1]) {
					if (dfs(i, nSum, cnt + 1)) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
