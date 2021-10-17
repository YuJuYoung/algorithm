package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_16724 {
	
	private static char[][] map;
	private static int[][] count;
	
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 }; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		count = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int c = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (count[i][j] == 0) {
					int tmp = dfs(j, i, c + 1);
					
					if (c < tmp) {
						c = tmp;
					}
				}
			}
		}
		System.out.println(c);
	}
	
	private static int dfs(int x, int y, int c) {
		if (count[y][x] != 0) {
			return count[y][x];
		}
		count[y][x] = c;
		
		int d = d(map[y][x]);
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		return count[y][x] = dfs(nx, ny, c);
	}
	
	private static int d(char c) {
		if (c == 'U') {
			return 3;
		} else if (c == 'D') {
			return 2;
		} else if (c == 'R') {
			return 0;
		} else {
			return 1;
		}
	}

}
