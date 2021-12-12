package ±¸Çö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_18111 {
	
	private static int N, M, B;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		int minH = Integer.MAX_VALUE, maxH = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				minH = Math.min(minH, map[i][j]);
				maxH = Math.max(maxH, map[i][j]);
			}
		}
		
		int[] ans = { Integer.MAX_VALUE, maxH };
		
		for (int height = minH; height <= maxH; height++) {
			int time = play(height);
			
			if (time < ans[0] || (time == ans[0] && ans[1] < height)) {
				ans[0] = time;
				ans[1] = height;
			}
		}
		System.out.println(ans[0] + " " + ans[1]);
	}
	
	private static int play(int height) {
		int time = 0;
		int blockCount = B;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] < height) {
					int plus = height - map[i][j];
					
					time += plus;
					blockCount -= plus;
				}
				if (map[i][j] > height) {
					int minus = map[i][j] - height;
					
					time += minus * 2;
					blockCount += minus;
				}
			}
		}
		return blockCount < 0 ? Integer.MAX_VALUE : time;
	}

}
