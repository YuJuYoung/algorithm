package ±¸Çö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1022 {
	
	private static int r1, c1, r2, c2;
	private static int[][] vortex;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		vortex = new int[r2 - r1 + 1][c2 - c1 + 1];
		
		solve();
	}
	
	private static void solve() {
		int maxVal = 0;
		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				int val = getVal(i, j);
				vortex[i - r1][j - c1] = val;
				maxVal = Math.max(maxVal, val);
			}
		}
		
		int maxDigit = 0;
		while (maxVal / ((int) Math.pow(10, maxDigit)) > 0) {
			maxDigit++;
		}
		printVortex(maxDigit);
	}
	
	private static int getVal(int i, int j) {
		if (i == 0 && j == 0) {
			return 1;
		}
		int maxIdx = Math.max(Math.abs(i), Math.abs(j));
		
		int maxVal = (int) Math.pow(maxIdx * 2 + 1, 2);
		int minVal = (int) Math.pow((maxIdx - 1) * 2 + 1, 2) + 1;
		
		if (i == -maxIdx || (j == maxIdx && i < maxIdx)) {
			return minVal + getDist(i, j, maxIdx - 1, maxIdx);
		}
		return maxVal - getDist(i, j, maxIdx, maxIdx);
	}
	
	private static int getDist(int y1, int x1, int y2, int x2) {
		return Math.abs(y2 - y1) + Math.abs(x2 - x1);
	}
	
	private static void printVortex(int maxDigit) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < r2 - r1 + 1; i++) {
			for (int j = 0; j < c2 - c1 + 1; j++) {
				sb.append(String.format("%" + maxDigit + "s", vortex[i][j]));
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

}
