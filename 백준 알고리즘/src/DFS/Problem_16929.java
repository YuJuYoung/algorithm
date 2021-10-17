package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_16929 {
	
	private static int N, M;
	private static char[][] map;
	private static boolean[][] visited;
	
	private static int[] dx = { 0, -1, 0, 1 };
	private static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && dfs(j, i, -1)) {
					System.out.println("Yes");
					return;
				}
			}
		}
		System.out.println("No");
	}
	
	private static boolean dfs(int x, int y, int last) {
		visited[y][x] = true;
		
		for (int i = 0; i < 4; i++) {
			if (last == i) {
				continue;
			}
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (isInside(nx, ny) && map[ny][nx] == map[y][x]) {
				if (visited[ny][nx]) {
					return true;
				}
				if (dfs(nx, ny, (i + 2) % 4)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < M && y >= 0 && y < N;
	}

}
