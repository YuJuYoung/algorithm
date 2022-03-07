package ±¸Çö;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_4902 {
	
	private static int N, max;
	private static int[][] cache;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = 1;
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			if ((N = Integer.parseInt(st.nextToken())) == 0) {
				break;
			}
			cache = new int[N][N * 2 - 1];
			
			max = cache[0][0] = Integer.parseInt(st.nextToken());
			
			for (int i = 1; i < N; i++) {
				for (int j = 0; j < (i + 1) * 2 - 1; j++) {
					int num = Integer.parseInt(st.nextToken());
					
					max = Math.max(max, num);
					cache[i][j] = cache[i - 1][j] + num;
				}
			}
			
			setMax();
			bw.write(t++ + ". " + max);
			bw.newLine();
		}
		bw.close();
	}
	
	private static void setMax() {
		for (int len = 1; len < N; len++) {
			for (int i = 1; i < N; i++) {
				for (int j = 0; j < (i + 1) * 2 - 1; j++) {
					max = Math.max(max, getArea(len, i, j));
				}
			}
		}
	}
	
	private static int getArea(int len, int i, int j) {
		if (j - len < 0) {
			return -1;
		}
		
		int area = 0;
		int r = 1;
		
		for (int k = j; k >= j - len; k--) {
			area += cache[i][k] - cache[i - r][k];
			r += 2;
		}
		return area;
	}

}
