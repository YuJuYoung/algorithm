package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_14570 {
	
	private static int[][] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		tree = new int[N + 1][2];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 2; j++) {
				tree[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dfs(1, Long.parseLong(br.readLine())));
	}
	
	private static int dfs(int n, long K) {
		if (tree[n][0] == -1 && tree[n][1] == -1) {
			return n;
		}
		if (tree[n][0] == -1) {
			return dfs(tree[n][1], K);
		}
		if (tree[n][1] == -1) {
			return dfs(tree[n][0], K);
		}
		
		if (K == 1) {
			return dfs(tree[n][0], 1);
		}
		if (K % 2 == 1) {
			return dfs(tree[n][0], K / 2 + 1);
		} else {
			return dfs(tree[n][1], K / 2);
		}
	}

}
