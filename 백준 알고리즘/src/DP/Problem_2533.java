package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2533 {
	
	private static int[][] cache;
	private static Node[] tree;
	private static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		cache = new int[N + 1][2];
		tree = new Node[N + 1];
		isVisited = new boolean[N + 1];
		
		while (N-- > 1) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u] = new Node(v, tree[u]);
			tree[v] = new Node(u, tree[v]);
		}
		dfs(1);
		System.out.println(min(cache[1][1], cache[1][0]));
	}
	
	private static void dfs(int n) {
		isVisited[n] = true;
		cache[n][0] = 0;
		cache[n][1] = 1;
		
		for (Node next = tree[n]; next != null; next = next.next) {
			if (!isVisited[next.n]) {
				dfs(next.n);
				
				cache[n][0] += cache[next.n][1];
				cache[n][1] += min(cache[next.n][0], cache[next.n][1]);
			}
		}
	}
	
	private static int min(int a, int b) {
		return a < b ? a : b;
	}
	
	private static class Node {
		Node next;
		int n;
		
		public Node(int n, Node next) {
			this.n = n;
			this.next = next;
		}
	}

}