package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_12763 {
	
	private static int N, T, M;
	
	private static Node[] graph;
	private static int[] cache;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		graph = new Node[N + 1];
		cache = new int[N + 1];
		visited = new boolean[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int L = Integer.parseInt(br.readLine()); L > 0; L--) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[u] = new Node(v, t, c, graph[u]);
			graph[v] = new Node(u, t, c, graph[v]);
		}
		
		dfs(1, 0, 0);
		System.out.println(cache[N] == 0 ? -1 : cache[N]);
	}
	
	private static boolean dfs(int n, int t, int c) {
		if (cache[n] != 0 && cache[n] <= c) {
			return false;
		}
		if (n == N) {
			cache[n] = c;
			return true;
		}
		visited[n] = true;
		
		for (Node node = graph[n]; node != null; node = node.next) {
			if (visited[node.n]) {
				continue;
			}
			
			int nt = t + node.t;
			int nc = c + node.c;
			
			if (nt > T || nc > M) {
				continue;
			}
			if (dfs(node.n, nt, nc)) {
				cache[n] = c;
			}
		}
		visited[n] = false;
		
		return false;
	}
	
	private static class Node {
		int n, t, c;
		Node next;
		
		public Node(int n, int t, int c, Node node) {
			this.n = n;
			this.t = t;
			this.c = c;
			next = node;
		}
	}

}
