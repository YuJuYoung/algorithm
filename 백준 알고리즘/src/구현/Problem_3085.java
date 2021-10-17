package ±¸Çö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_3085 {
	
	private static int N;
	private static char[][] map;
	private static int[] xCache, yCache;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		xCache = new int[N];
		yCache = new int[N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		System.out.println(solve());
	}
	
	private static int solve() {
		setCache();
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i + 1 < N && map[i][j] != map[i + 1][j]) {
					swap(i, j, i + 1, j);
					
					int value = getMax(i, i + 1, j, j);
					if (value == N) {
						return N;
					}
					if (value > max) {
						max = value;
					}
					swap(i, j, i + 1, j);
				}
				if (j + 1 < N && map[i][j] != map[i][j + 1]) {
					swap(i, j, i, j + 1);
					
					int value = getMax(i, i, j, j + 1);
					if (value == N) {
						return N;
					}
					if (value > max) {
						max = value;
					}
					swap(i, j, i, j + 1);
				}
			}
		}
		return max;
	}
	
	private static int getMax(int si, int ei, int sj, int ej) {
		int max = 1;
		
		for (int i = 0; i < N; i++) {
			if (i >= si && i <= ei) {
				int count = 1;
				
				for (int j = 1; j < N; j++) {
					if (map[i][j] == map[i][j - 1]) {
						count++;
					} else {
						max = Math.max(max, count);
						count = 1;
					}
				}
				max = Math.max(max, count);
			} else {
				max = Math.max(max, xCache[i]);
			}
		}
		for (int j = 0; j < N; j++) {
			if (j >= sj && j <= ej) {
				int count = 1;
				
				for (int i = 1; i < N; i++) {
					if (map[i][j] == map[i - 1][j]) {
						count++;
					} else {
						max = Math.max(max, count);
						count = 1;
					}
				}
				max = Math.max(max, count);
			} else {
				max = Math.max(max, yCache[j]);
			}
		}
		return max;
	}
	
	private static void swap(int i, int j, int k, int l) {
		char tmp = map[i][j];
		map[i][j] = map[k][l];
		map[k][l] = tmp;
	}
	
	private static void setCache() {
		for (int i = 0; i < N; i++) {
			int xCount = 1;
			int yCount = 1;
			
			for (int j = 1; j < N; j++) {
				if (map[i][j] == map[i][j - 1]) {
					xCount++;
				} else {
					xCache[i] = Math.max(xCache[i], xCount);
					xCount = 1;
				}
				xCache[i] = Math.max(xCache[i], xCount);
				
				if (map[j][i] == map[j - 1][i]) {
					yCount++;
				} else {
					yCache[i] = Math.max(yCache[i], yCount);
					yCount = 1;
				}
				yCache[i] = Math.max(yCache[i], yCount);
			}
			xCache[i] = xCount;
			yCache[i] = yCount;
		}
	}

}
