package ±¸Çö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1022 {
	
	private static int r1, c1, r2, c2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
	}
	
	private static int[][] solve() {
		int[][] arr = new int[r2 - r1][c2 - c1];
		
		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j < c2; j++) {
				
			}
		}
		return arr;
	}

}
