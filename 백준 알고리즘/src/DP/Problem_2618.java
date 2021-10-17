package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2618 {
	
	private static Point[][] event;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int W = Integer.parseInt(br.readLine());
		int[][] dp = new int[W + 1][W + 1];
		Cache[][] cache = new Cache[W + 1][W + 1];
		event = new Point[W + 1][2];
		
		for (int i = 1; i <= W; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			event[i][0] = event[i][1] = new Point(x, y);
		}
		event[0][0] = new Point(0, 0);
		event[0][1] = new Point(N - 1, N - 1);
		
		cache[0][0] = new Cache(-1, -1, -1);
		for (int i = 1; i <= W; i++) {
			dp[0][i] = dp[0][i - 1] + calD(i, i - 1, 1);
			dp[i][0] = dp[i - 1][0] + calD(i, i - 1, 0);
			cache[0][i] = new Cache(0, i - 1, 2);
			cache[i][0] = new Cache(i - 1, 0, 1);
		}
		
		Cache tmp = null;
		int minD = Integer.MAX_VALUE;
		for (int i = 1; i <= W; i++) {
			for (int j = 1; j <= W; j++) {
				if (i == j) {
					continue;
				}
				int min = Integer.MAX_VALUE;
				int lastA = 0, lastB = 0, lastP;
				
				if (i > j) {
					if (i - 1 != j) {
						min = dp[i - 1][j] + calD(i, i - 1, 0);
						lastA = i - 1;
						lastB = j;
					} else {
						for (int k = j - 1; k >= 0; k--) {
							int tmpD = dp[k][j] + calD(i, k, 0);
							
							if (min > tmpD) {
								min = tmpD;
								lastA = k;
								lastB = j;
							}
						}
					}
					lastP = 1;
				} else {
					if (j - 1 != i) {
						min = dp[i][j - 1] + calD(j, j - 1, 1);
						lastA = i;
						lastB = j - 1;
					} else {
						for (int k = i - 1; k >= 0; k--) {
							int tmpD = dp[i][k] + calD(j, k, 1);
							
							if (min > tmpD) {
								min = tmpD;
								lastA = i;
								lastB = k;
							}
						}
					}
					lastP = 2;
				}
				
				dp[i][j] = min;
				cache[i][j] = new Cache(lastA, lastB, lastP);
				if (i == W || j == W) {
					if (minD > dp[i][j]) {
						tmp = cache[i][j];
						minD = dp[i][j];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (tmp.lastP != -1) {
			sb.append("\n").append(tmp.lastP);
			tmp = cache[tmp.lastA][tmp.lastB];
		}
		System.out.print(minD + "\n" + sb.reverse());
	}
	
	private static int calD(int a, int b, int c) {
		Point p1 = event[a][c];
		Point p2 = event[b][c];
		
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
	
	private static class Cache {
		int lastA, lastB, lastP;
		
		public Cache(int a, int b, int p) {
			lastA = a;
			lastB = b;
			lastP = p;
		}
	}
	
	private static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
