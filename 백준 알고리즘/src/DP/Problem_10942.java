package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_10942 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		boolean[][] dp = new boolean[N + 1][N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] == arr[i - 1]) {
				dp[i - 1][i] = true;
			}
			dp[i][i] = true;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 1; i + j <= N; j++) {
				if (arr[j] == arr[i + j] && dp[j + 1][i + j - 1]) {
					dp[j][i + j] = true;
				}
			}
		}
		for (int M = Integer.parseInt(br.readLine()); M > 0; M--) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(dp[a][b] ? "1\n" : "0\n");
		}
		bw.close();
	}

}
