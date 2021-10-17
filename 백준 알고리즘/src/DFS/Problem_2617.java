package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2617 {
	
	private static Node[][] tree;
	private static int[][] cache;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		tree = new Node[N + 1][2];
		cache = new int[N + 1][2];
		visited = new boolean[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u][0] = new Node(v, tree[u][0]);
			tree[v][1] = new Node(u, tree[v][1]);
		}
		
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			
			dfs(i, 0);
			dfs(i, 1);
		}
		
		int tmp = (N + 1) / 2, count = 0;
		for (int i = 1; i <= N; i++) {
			if (cache[i][0] > tmp || cache[i][1] > tmp) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	private static void dfs(int n, int index) {
		visited[n] = true;
		cache[n][index]++;
		
		for (Node next = tree[n][index]; next != null; next = next.next) {
			if (!visited[next.n]) {
				dfs(next.n, index);
			}
		}
	}
	
	private static class Node {
		int n;
		Node next;
		
		public Node(int n, Node next) {
			this.n = n;
			this.next = next;
		}
	}

}
