package DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_14615 {
	
	private static Node[][] graph;
	private static boolean[][] connected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new Node[N + 1][2];
		connected = new boolean[N + 1][2];
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u][0] = new Node(v, graph[u][0]);
			graph[v][1] = new Node(u, graph[v][1]);
		}
		
		dfs(1, 0);
		dfs(N, 1);
		
		for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
			int C = Integer.parseInt(br.readLine());
			
			if (connected[C][0] && connected[C][1]) {
				bw.write("Defend the CTP\n");
			} else {
				bw.write("Destroyed the CTP\n");
			}
		}
		bw.close();
	}
	
	private static void dfs(int n, int start) {
		connected[n][start] = true;
		
		for (Node next = graph[n][start]; next != null; next = next.next) {
			dfs(next.n, start);
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
