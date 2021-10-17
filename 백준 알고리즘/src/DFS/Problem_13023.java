package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_13023 {
	
	private static Node[] graph;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new Node[N];
		visited = new boolean[N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u] = new Node(v, graph[u]);
			graph[v] = new Node(u, graph[v]);
		}
		
		for (int i = 0; i < N; i++) {
			if (dfs(i, 0)) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}
	
	private static boolean dfs(int n, int count) {
		if (count == 4) {
			return true;
		}
		visited[n] = true;
		
		for (Node next = graph[n]; next != null; next = next.next) {
			if (!visited[next.n]) {
				if (dfs(next.n, count + 1)) {
					return true;
				}
			}
		}
		return visited[n] = false;
	}
	
	private static class Node {
		int n;
		Node next;
		
		public Node (int n, Node next) {
			this.n = n;
			this.next = next;
		}
	}

}
