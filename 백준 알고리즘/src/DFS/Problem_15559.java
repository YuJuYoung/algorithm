package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_15559 {
	
	private static int N, M;
	private static char[][] map;
	private static int[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int count = 0, n = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != '*' && dfs(j, i, n++)) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	private static boolean dfs(int x, int y, int n) {
		if (isOutside(x, y) || visited[y][x] == n) {
			return true;
		}
		if (visited[y][x] != 0 && visited[y][x] != n) {
			return false;
		}
		visited[y][x] = n;
		
		boolean check = false;
		if (map[y][x] == 'N') {
			check = dfs(x, y - 1, n);
		} else if (map[y][x] == 'S') {
			check = dfs(x, y + 1, n);
		} else if (map[y][x] == 'E') {
			check = dfs(x + 1, y, n);
		} else {
			check = dfs(x - 1, y, n);
		}
		return check;
	}
	
	private static boolean isOutside(int x, int y) {
		return x == -1 || x == M || y == -1 || y == N;
	}

}
