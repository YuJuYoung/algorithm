package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_14501 {
	
	private static int N, max = 0;
	private static int[][] arr;
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		dp = new int[N + 1];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			int next = i + arr[i][0];
			
			if (next <= N) {
				dp[next] = Math.max(dp[next], dp[i] + arr[i][1]);
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(Math.max(max, dp[N]));
	}

}
