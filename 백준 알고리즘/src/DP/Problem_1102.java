package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_1102 {
	
	private static int N, P, start;
	private static int[][] costs;
	private static char[] YN;
	
	private static int[][][] dp;
	private static boolean[][] visited;
	private static List<Integer> broke;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		costs = new int[N][N];
		
		for (int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				costs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		YN = br.readLine().toCharArray();
		P = Integer.parseInt(br.readLine());
		start = 0;
		
		for (int i = 0; i < N; i++) {
			if (YN[i] == 'N') {
				broke.add(i);
			} else {
				start += 1 << i;
			}
		}
		
		int cnt = P - N - broke.size();
		
		if (cnt <= 0) {
			System.out.println(0);
		} else {
			int len = broke.size();
			
			dp = new int[len][cnt + 1][2];
			visited = new boolean[len][cnt + 1];
			
			for (int i = 0; i < len; i++) {
				int index = broke.get(i);
			}
			System.out.println(visited[len - 1][cnt] ? dp[len - 1][cnt][1] : -1);
		}
	}
	
	private static int[] getMin(int index, int YNBit) {
		int[] min = { 0, Integer.MAX_VALUE };
		
		for (int i = 0; i < N; i++) {
			if (i == index) {
				continue;
			}
		}
		return null;
	}

}
