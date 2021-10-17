package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1303 {
	
	private static int N, M;
	private static char[][] map;
	
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int W = 0, B = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'W') {
					W += Math.pow(dfs(j, i, 'W'), 2);
				}
				if (map[i][j] == 'B') {
					B += Math.pow(dfs(j, i, 'B'), 2);
				}
			}
		}
		System.out.println(W + " " + B);
	}
	
	private static int dfs(int x, int y, char c) {
		map[y][x] = '*';
		
		int count = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (isInside(nx, ny) && map[ny][nx] == c) {
				count += dfs(nx, ny, c);
			}
		}
		return count;
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < M && y >= 0 && y < N;
	}

}
