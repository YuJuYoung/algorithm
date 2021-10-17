package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_17090 {
	
	private static int N, M;
	private static int[][] maze;
	private static boolean[][] visited;
	private static boolean[][] escaped;
	
	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		visited = new boolean[N][M];
		escaped = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				char c = str.charAt(j);
				
				if (c == 'U') {
					maze[i][j] = 0;
				} else if (c == 'R') {
					maze[i][j] = 1;
				} else if (c == 'D') {
					maze[i][j] = 2;
				} else {
					maze[i][j] = 3;
				}
			}
		}
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (dfs(j, i)) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	private static boolean dfs(int x, int y) {
		if (x < 0 || x >= M || y < 0 || y >= N || escaped[y][x]) {
			return true;
		}
		if (visited[y][x]) {
			return false;
		}
		visited[y][x] = true;
		
		int nx = x + dx[maze[y][x]];
		int ny = y + dy[maze[y][x]];
		
		return escaped[y][x] = dfs(nx, ny);
	}
	
}
