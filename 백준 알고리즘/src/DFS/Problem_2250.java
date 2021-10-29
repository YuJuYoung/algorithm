package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2250 {
	
	private static int[][] tree;
	private static int[][] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		tree = new int[N + 1][2];
		result = new int[N][2];
		
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int parent = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			tree[parent][0] = left;
			tree[parent][1] = right;
		}
	}
	
	private static int dfs(int n, int floor) {
		int left = 0, right = 0;
		
		if (tree[n][0] != -1) {
			left = dfs(tree[n][0], floor + 1);
		}
		
		if (tree[n][1] != -1) {
			right = dfs(tree[n][1], floor + 1);
		}
		return left + right + 1;
	}

}
