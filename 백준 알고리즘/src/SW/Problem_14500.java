package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_14500 {
	
	private static int N, M, max = 0;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				one(j, i);
				two(j, i);
				three(j, i);
				four(j, i);
				five(j, i);
			}
		}
		System.out.println(max);
	}
	
	private static void one(int x, int y) {
		if (x < M - 3) {
			max = max(max, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y][x + 3]);
		}
		if (y < N - 3) {
			max = max(max, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 3][x]);
		}
	}
	
	private static void two(int x, int y) {
		if (x < M - 1 && y < N - 1) {
			max = max(max, map[y][x] + map[y + 1][x] + map[y][x + 1] + map[y + 1][x + 1]);
		}
	}
	
	private static void three(int x, int y) {
		if (x < M - 1 && y < N - 1) {
			int tmp1 = map[y][x] + map[y + 1][x] + map[y][x + 1] + map[y + 1][x + 1];
			
			if (y < N - 2) {
				int tmp2 = tmp1 + map[y + 2][x] + map[y + 2][x + 1];
				
				max = max(max, tmp2 - map[y][x] - map[y + 1][x]);
				max = max(max, tmp2 - map[y + 1][x] - map[y + 2][x]);
				max = max(max, tmp2 - map[y][x + 1] - map[y + 1][x + 1]);
				max = max(max, tmp2 - map[y + 1][x + 1] - map[y + 2][x + 1]);
			}
			if (x < M - 2) {
				int tmp2 = map[y][x + 2] + map[y + 1][x + 2];
				
				max = max(max, tmp2 - map[y][x] - map[y][x + 1]);
				max = max(max, tmp2 - map[y][x + 1] - map[y][x + 2]);
				max = max(max, tmp2 - map[y + 1][x] - map[y + 1][x + 1]);
				max = max(max, tmp2 - map[y + 1][x + 1] - map[y + 1][x + 2]);
			}
		}
	}
	
	private static void four(int x, int y) {
		int tmp = 0;
		
		if (x < M - 1 && y < N - 2) {
			tmp = map[y + 1][x] + map[y + 1][x + 1];
			
			max = max(max, tmp + map[y][x] + map[y + 2][x + 1]);
			max = max(max, tmp + map[y][x + 1] + map[y + 2][x]);
		}
		if (x < M - 2 && y < N - 1) {
			tmp = map[y][x + 1] + map[y + 1][x + 1];
			
			max = max(max, tmp + map[y][x] + map[y + 1][x + 2]);
			max = max(max, tmp + map[y + 1][x] + map[y][x + 2]);
		}
	}
	
	private static void five(int x, int y) {
		int tmp = 0;
		
		if (x < M - 2 && y < N - 1) {
			tmp = map[y][x + 1] + map[y + 1][x + 1];
			
			max = max(max, tmp + map[y][x] + map[y][x + 2]);
			max = max(max, tmp + map[y + 1][x] + map[y + 1][x + 2]);
		}
		if (x < M - 1 && y < N - 2) {
			tmp = map[y + 1][x] + map[y + 1][x + 1];
			
			max = max(max, tmp + map[y][x] + map[y + 2][x]);
			max = max(max, tmp + map[y][x + 1] + map[y + 2][x + 1]);
		}
	}
	
	private static int max(int a, int b) {
		return a < b ? b : a;
	}

}
