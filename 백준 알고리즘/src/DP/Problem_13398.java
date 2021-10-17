package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_13398 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[][] cache = new int[2][n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = cache[0][0] = arr[0];
		for (int i = 1; i < n; i++) {
			cache[0][i] = max(cache[0][i - 1] + arr[i], arr[i]);
			max = max(max, cache[0][i]);
		}
		
		cache[1][n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			cache[1][i] = max(cache[1][i + 1] + arr[i], arr[i]);
		}
		
		for (int i = 1; i < n - 1; i++) {
			max = max(max, cache[0][i - 1] + cache[1][i + 1]);
		}
		System.out.print(max);
	}
	
	private static int max(int a, int b) {
		return a > b ? a : b;
	}

}
