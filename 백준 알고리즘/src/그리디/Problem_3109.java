package ±×¸®µð;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_3109 {
	private static int R, C, count = 0;
	private static char[][] map;
	private static int[] dy = { -1, 0, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < R; i++) {
			map[i][0] = '*';
			dfs(0, i);
		}
		System.out.println(count);
	}
	
	private static boolean dfs(int x, int y) {
		if (x + 1 == C - 1) {
			count++;
			return true;
		}
		for (int i = 0; i < 3; i++) {
			int ny = y + dy[i];
			if (ny < R && ny >= 0 && map[ny][x + 1] == '.') {
				map[ny][x + 1] = '*';
				if (dfs(x + 1, ny)) {
					return true;
				}
			}
		}
		return false;
	}
	
}
