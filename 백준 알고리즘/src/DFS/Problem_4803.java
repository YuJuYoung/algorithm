package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_4803 {
	
	private static Node[] graph;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int test = 1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			if (n == 0) {
				break;
			}
			int m = Integer.parseInt(st.nextToken());
			graph = new Node[n + 1];
			visited = new boolean[n + 1];
			
			while (m-- > 0) {
				st = new StringTokenizer(br.readLine());
				
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				graph[u] = new Node(v, graph[u]);
				graph[v] = new Node(u, graph[v]);
			}
			
			int count = 0;
			for (int i = 1; i <= n; i++) {
				if (dfs(i, 0)) {
					count++;
				}
			}
			
			sb.append("Case ").append(test++).append(": ");
			if (count == 0) {
				sb.append("No trees.");
			} else if (count == 1) {
				sb.append("There is one tree.");
			} else {
				sb.append("A forest of ").append(count).append(" trees.");
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
	
	private static boolean dfs(int n, int last) {
		if (visited[n]) {
			return false;
		}
		visited[n] = true;
		
		boolean isTree = true;
		for (Node next = graph[n]; next != null; next = next.next) {
			if (next.n == last) {
				continue;
			}
			isTree = dfs(next.n, n);
		}
		return isTree;
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
