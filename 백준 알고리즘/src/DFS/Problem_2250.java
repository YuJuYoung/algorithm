package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2250 {
	
	private static int[][] tree;
	private static int[] left;
	private static int[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		tree = new int[N + 1][2];
		left = new int[N + 1];
		
		boolean[] isRoot = new boolean[N + 1];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int parent = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			tree[parent][0] = left;
			tree[parent][1] = right;
			
			if (left != -1) {
				isRoot[left] = true;
			}
			if (right != -1) {
				isRoot[right] = true;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (!isRoot[i]) {
				ans = new int[] { i, 0 };
				dfs(i, 1);
				break;
			}
		}
		System.out.println(ans[0] + " " + (ans[1] + 1));
	}
	
	private static int cnt = 0;
	
	private static void dfs(int n, int depth) {
		if (tree[n][0] != -1) {
			dfs(tree[n][0], depth + 1);
		}
		cnt++;
		
		if (left[depth] == 0) {
			left[depth] = cnt;
		} else {
			int width = cnt - left[depth];
			
			if (width > ans[1] || (width == ans[1] && depth < ans[0])) {
				ans[0] = depth;
				ans[1] = width;
			}
		}
		
		if (tree[n][1] != -1) {
			dfs(tree[n][1], depth + 1);
		}
	}

}
