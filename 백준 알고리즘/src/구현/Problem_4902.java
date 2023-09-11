package ±¸Çö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_4902 {
	
	private static int[][] prefixSum;
	private static int lineNum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int testCaseNum = 1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lineNum = Integer.parseInt(st.nextToken());
			if (lineNum == 0) {
				break;
			}
			prefixSum = new int[lineNum][(lineNum - 1) * 2 + 2];
			
			for (int i = 1; i <= lineNum; i++) {
				for (int j = 1; j <= (i - 1) * 2 + 1; j++) {
					prefixSum[i - 1][j] = Integer.parseInt(st.nextToken());
					prefixSum[i - 1][j] = prefixSum[i - 1][j] + prefixSum[i - 1][j - 1];
				}
			}
			
			sb.append(testCaseNum++);
			sb.append(". ");
			sb.append(solve());
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	private static int solve() {
		int maxSize = Integer.MIN_VALUE;
		for (int i = 1; i <= lineNum; i++) {
			for (int j = 0; j < (i - 1) * 2 + 1; j++) {
				if (j % 2 == 0) {
					maxSize = Math.max(maxSize, getNormalTriangleMaxSize(i, j));
				} else {
					maxSize = Math.max(maxSize, getInvertedTriangleMaxSize(i ,j));
				}
			}
		}
		return maxSize;
	}
	
	// »ï°¢Çü
	private static int getNormalTriangleMaxSize(int i, int j) {
		int maxTriangle = Integer.MIN_VALUE;
		int triangleSum = 0;
		for (int k = i; k <= lineNum; k++) {
			triangleSum += prefixSum[k - 1][j + (k - i) * 2 + 1] - prefixSum[k - 1][j];
			maxTriangle = Math.max(maxTriangle, triangleSum);
		}
		return maxTriangle;
	}
	
	// ¿ª»ï°¢Çü
	private static int getInvertedTriangleMaxSize(int i, int j) {
		int maxTriangle = Integer.MIN_VALUE;
		int triangleSum = 0;
        
        // j - (i - k) * 2 ¿ª»ï°¢ÇüÀÇ ÁÂÃø»ó´Ü ¼öÆò ÁÂÇ¥ - 1
        // (k - 1) * 2 + 1 ¿ª»ï°¢ÇüÀÇ ¿ìÃø»ó´Ü ¼öÆò ÁÂÇ¥
		for (int k = i; j - (i - k) * 2 >= 0 && j + 1 <= (k - 1) * 2 + 1; k--) {
			triangleSum += prefixSum[k - 1][j + 1] - prefixSum[k - 1][j - (i - k) * 2];
			maxTriangle = Math.max(maxTriangle, triangleSum);
		}
		return maxTriangle;
	}

}
