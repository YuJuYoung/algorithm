package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1199 {
	
	private static int N;
	private static boolean[][] visited;
	private static Node[] graph;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1][2];
		graph = new Node[N + 1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					graph[i] = new Node(j, graph[i]);
				}
			}
		}
	}
	
	private static class Node {
		boolean visited = false;
		int n;
		Node next;
		
		public Node(int n, Node node) {
			this.n = n;
			next = node;
		}
	}

}
