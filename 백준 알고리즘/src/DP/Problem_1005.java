package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_1005 {
	
	private static int[] D, dp;
	private static Route[] routes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			D = new int[N + 1];
			dp = new int[N + 1];
			routes = new Route[N + 1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				D[i] = Integer.parseInt(st.nextToken());
				dp[i] = -1;
			}
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				if (routes[Y] == null) {
					routes[Y] = new Route();
				}
				routes[Y].list.add(X);
			}
			bw.write(dfs(Integer.parseInt(br.readLine())) + "\n");
		}
		bw.close();
	}
	
	private static int dfs(int Y) {
		if (dp[Y] != -1) {
			return dp[Y];
		}
		
		int max = 0;
		if (routes[Y] != null) {
			for (int X : routes[Y].list) {
				max = Math.max(max, dfs(X));
			}
		}
		return dp[Y] = D[Y] + max;
	}
	
	private static class Route {
		List<Integer> list = new ArrayList<>();
	}

}
