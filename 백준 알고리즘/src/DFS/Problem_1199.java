package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1199 {
	
	private static int N;
	private static int[][] arr;
	private static boolean[][] visited;
	private static StringBuilder ans = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 1);
		System.out.println(ans.reverse());
	}
	
	private static boolean dfs(int n, int count) {
		if (count == N) {
			if (arr[n][0] > 0) {
				return true;
			}
			return false;
		} else {
			for (int i = 1; i < N; i++) {
				if (arr[n][i] > 0 && !visited[n][i]) {
					visited[n][i] = true;
					arr[n][i]--;
				}
			}
		}
		return false;
	}

}
