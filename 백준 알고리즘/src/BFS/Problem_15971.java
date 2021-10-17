package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_15971 {
	
	private static Node[] graph;
	private static int[][] cache;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		if (N == 1 || A == B) {
			System.out.println(0);
			return;
		}
		graph = new Node[N + 1];
		cache = new int[N + 1][2];
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			graph[u] = new Node(v, d, graph[u]);
			graph[v] = new Node(u, d, graph[v]);
		}
		dfs(A, B, -1, 0);
		System.out.println(cache[B][0] - cache[B][1]);
	}
	
	private static void dfs(int A, int B, int max, int d) {
		cache[A][0] = d;
		cache[A][1] = max;
		
		if (A == B) {
			return;
		}
		for (Node next = graph[A]; next != null; next = next.next) {
			int tmpMax = Math.max(max, next.d);
			int tmpD = d + next.d;
			
			if (cache[next.n][1] == 0) {
				dfs(next.n, B, tmpMax, tmpD);
			}
		}
	}
	
	private static class Node {
		int n, d;
		Node next;
		
		public Node(int n, int d, Node next) {
			this.n = n;
			this.d = d;
			this.next = next;
		}
	}

}
