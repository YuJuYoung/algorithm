package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_8872 {
	
	private static int N, M, L;
	private static Node[] graph;

	public static void main(String[] args) throws IOException {
		setVar();
	}
	
	private static void setVar() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		graph = new Node[N];
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			
			graph[A] = new Node(B, T, graph[A]);
			graph[B] = new Node(A, T, graph[B]);
		}
	}
	
	private static void solve() {
		for (int i = 0; i < N; i++) {
			
		}
	}
	
	private static class Node {
		int n, t, cache = 0;
		Node next;
		
		public Node(int n, int T, Node node) {
			this.n = n;
			this.t = T;
			next = node;
		}
	}

}
