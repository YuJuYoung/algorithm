package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11053 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			dp[i] = 1001;
			for (int j = 0; j < N; j++) {
				if (dp[j] >= num) {
					dp[j] = num;
					break;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			if (dp[i] == 1001) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(N);
	}

}
