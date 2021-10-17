package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem_11725 {
	
	private static Node[] tree;
	private static int[] cache;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		tree = new Node[N + 1];
		cache = new int[N + 1];
		
		for (int i = 1; i < N; i++) {
			StringTokenizer st =  new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u] = new Node(v, tree[u]);
			tree[v] = new Node(u ,tree[v]);
		}
		bfs();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(cache[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		cache[1] = -1;
		
		while (!q.isEmpty()) {
			int n = q.poll();
			
			for (Node next = tree[n]; next != null; next = next.next) {
				if (cache[next.n] == 0) {
					cache[next.n] = n;
					q.add(next.n);
				}
			}
		}
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
