package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_14267 {
	
	private static Node[] tree;
	private static int[] cache;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		tree = new Node[n + 1];
		cache = new int[n + 1];
		
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		for (int i = 2; i <= n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			tree[tmp] = new Node(i, tree[tmp]);
		}
		
		int[] arr = new int[n + 1];
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int i = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[i] += w;
		}
		for (int i = 1; i <= n; i++) {
			if (arr[i] > 0) {
				dfs(i, arr[i]);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(cache[i]).append(' ');
		}
		System.out.println(sb);
	}
	
	private static void dfs(int n, int w) {
		cache[n] += w;
		
		for (Node next = tree[n]; next != null; next = next.next) {
			dfs(next.n, w);
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
