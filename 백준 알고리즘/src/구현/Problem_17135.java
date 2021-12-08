package ±¸Çö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_17135 {
	
	private static int N, M, D, ans = 0;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		play(-1, 0);
		System.out.println(ans);
	}
	
	private static int[] archers = new int[3];
	
	private static void play(int last, int archer) {
		if (archer == 3) {
			ans = Math.max(ans, getScore());
		} else {
			for (int i = last + 1; i <= M - 3 + archer; i++) {
				play(archers[archer] = i, archer + 1);
			}
		}
	}
	
	private static int[][] copiedMap;
	
	private static int getScore() {
		int[][] attacked = new int[3][2];
		int score = 0;
		
		copiedMap = map.clone();
		
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < 3; j++) {
				attacked[j] = attack(archers[j], i, D - 1);
			}
			
			for (int[] pair : attacked) {
				if (pair == null) {
					continue;
				}
				int x = pair[0], y = pair[1];
				
				if (copiedMap[y][x] == 1) {
					score++;
				}
				copiedMap[y][x] = 0;
			}
		}
		return score;
	}
	
	private static int[] attack(int x, int y, int d) {
		for (int j = x - d; j <= x + d; j++) {
			if (j < 0 || j >= M) {
				continue;
			}
			
			for (int i = y; i >= y - (j - x + d + 1); i--) {
				if (i < 0) {
					continue;
				}
				
				if (copiedMap[i][j] == 1) {
					return new int[] { j, i };
				}
			}
		}
		return null;
	}

}
