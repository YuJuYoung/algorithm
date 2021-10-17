package ±×¸®µð;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10775 {
	
	private static int[] g = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		
		g = new int[G + 1];
		for (int i = 1; i <= G; i++) {
			g[i] = i;
		}
		
		int answer = 0;
		for (int i = 0; i < P; i++) {
			int airplane = Integer.parseInt(br.readLine());
			int x = find(airplane);
			
			if (x == 0) {
				break;
			}
			merge(x, x - 1);
			answer++;
		}
		System.out.println(answer);
	}
	
	private static void merge(int x, int y) {
		x = find(x);
		y = find(y);
		g[x] = y;
	}
	
	private static int find(int x) {
		if (g[x] == x) {
			return x;
		}
		return g[x] = find(g[x]);
	}

}
