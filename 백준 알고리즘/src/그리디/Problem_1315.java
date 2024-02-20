package 그리디;

import java.io.*;
import java.util.*;

public class Problem_1315 {
	
	private static int N;
	private static Quest[] quests;
	private static int[][] dp;
	private static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		quests = new Quest[N];
		dp = new int[1001][1001];
		isVisited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int STR = Integer.parseInt(st.nextToken());
			int INT = Integer.parseInt(st.nextToken());
			int PNT = Integer.parseInt(st.nextToken());
			quests[i] = new Quest(STR, INT, PNT);
		}
		System.out.println(dfs(1, 1));
	}
	
	private static int dfs(int STR, int INT) {
		if (dp[STR][INT] > 0) {
			return dp[STR][INT];
		}
		int PNT = 0;
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			if (quests[i].STR <= STR || quests[i].INT <= INT) {
				if (!isVisited[i]) {
					PNT += quests[i].PNT;
					isVisited[i] = true;
					list.add(i);
				}
				dp[STR][INT]++;
			}
		}
		if (list.size() == 0) {
			return dp[STR][INT];
		}
		for (int i = 0; i <= PNT; i++) {
			int nextSTR = Math.min(STR + i, 1000);
			int nextINT = Math.min(INT + PNT - i, 1000);
			dp[STR][INT] = Math.max(dfs(nextSTR, nextINT), dp[STR][INT]);
		}
		for (int index : list) {
			isVisited[index] = false;
		}
		return dp[STR][INT];
	}
	
	private static class Quest {
		int STR, INT, PNT;
		
		public Quest(int STR, int INT, int PNT) {
			this.STR = STR;
			this.INT = INT;
			this.PNT = PNT;
		}
	}

}