package 구현;

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
		
		int[] last = { play(minH), minH };
		
		for (int height = minH + 1; height <= maxH; height++) {
			int time = play(height);
			
			if (time > last[0]) {
				print(last);
				return;
			}
			last[0] = time;
			last[1]++;
		}
		print(last);
	}
	
	private static int play(int height) {
		int time = 0;
		int blockCount = B;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int dist = Math.abs(height - map[i][j]);
				
				if (map[i][j] < height) {
					time += dist;
					blockCount -= dist;
				}
				if (map[i][j] > height) {
					time += dist * 2;
					blockCount += dist;
				}
			}
		}
		return blockCount < 0 ? Integer.MAX_VALUE : time;
	}
	
	private static void print(int[] ans) {
		System.out.println(ans[0] + " " + ans[1]);
	}

}
