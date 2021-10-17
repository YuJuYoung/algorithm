package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_17616 {
	
	private static Node[][] tree;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		tree = new Node[2][N + 1];
		visited = new boolean[N + 1];
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			tree[0][V] = new Node(U, tree[0][V]);
			tree[1][U] = new Node(V, tree[1][U]);
		}
		
		System.out.println(dfs(0, X) + " " + (N - dfs(1, X) + 1));
	}
	
	private static int dfs(int index, int n) {
		visited[n] = true;
		
		int count = 1;
		for (Node next = tree[index][n]; next != null; next = next.next) {
			if (!visited[next.n]) {
				count += dfs(index, next.n);
			}
		}
		return count;
	}
	
	private static class Node {
		int n;
		Node next;
		
		public Node(int n, Node node) {
			this.n = n;
			next = node;
		}
	}

}
