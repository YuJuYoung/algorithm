package BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_12784 {
	
	private static Node[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			graph = new Node[N + 1];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int D = Integer.parseInt(st.nextToken());
				
				graph[a] = new Node(b, D, graph[a]);
				graph[b] = new Node(a, D, graph[b]);
			}
			
			int result = dfs(1, Integer.MAX_VALUE, 0);
			bw.write((result == Integer.MAX_VALUE ? 0 : result) + "\n");
		}
		bw.close();
	}
	
	private static int dfs(int n, int D, int last) {
		int nD = 0;
		
		for (Node node = graph[n]; node != null; node = node.next) {
			if (node.n == last) {
				continue;
			}
			nD += dfs(node.n, node.D, n);
		}
		return nD == 0 ? D : Math.min(D, nD);
	}
	
	private static class Node {
		int n, D;
		Node next;
		
		public Node(int n, int D, Node node) {
			this.n = n;
			this.D = D;
			next = node;
		}
	}

}
