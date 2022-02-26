package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_16287 {
	
	private static int w, n;
	private static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		w = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		A = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solve() ? "YES" : "NO");
	}
	
	private static boolean solve() {
		boolean[] visited = new boolean[w];
		
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int num = A[i] + A[j];
				
				if (num < w && visited[w - num]) {
					return true;
				}
			}
			
			for (int j = 0; j < i; j++) {
				int sum = A[i] + A[j];
				
				if (sum < w) {
					visited[sum] = true;
				}
			}
		}
		return false;
	}

}
