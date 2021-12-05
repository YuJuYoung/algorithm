package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_12763 {
	
	private static int T, M;
	private static Node[] graph;
	private static int[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		graph = new Node[N + 1];
		visited = new int[N + 1][2];
		
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
	}
	
	private static int solve() {
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (a[1] == b[1]) {
				return Integer.compare(a[0], b[0]);
			}
			return Integer.compare(a[1], b[1]);
		});
		
		pq.add(new int[] { 1, 0, 0 });
		visited[1][0] = visited[1][1] = -1;
		
		while (!pq.isEmpty()) {
			int[] poped = pq.poll();
		}
		return -1;
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
