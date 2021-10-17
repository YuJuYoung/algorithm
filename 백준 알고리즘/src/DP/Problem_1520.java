package DP;

import java.io.*;
import java.util.*;

public class Problem_1520 {
	
	private static int M, N;
	private static int[][] map, dp;
	private static int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		dp = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		dp[M - 1][N - 1] = 1;
		System.out.println(dfs(0 ,0));
	}
	
	private static int dfs(int x, int y) {
		dp[y][x]= 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (isInside(nx, ny) && map[ny][nx] < map[y][x]) {
				if (dp[ny][nx] == -1) {
					dp[ny][nx] = dfs(nx, ny);
				}
				dp[y][x] += dp[ny][nx];
			}
		}
		return dp[y][x];
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}
