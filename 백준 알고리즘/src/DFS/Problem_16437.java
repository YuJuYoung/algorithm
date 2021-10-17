package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_16437 {
	
	private static Node[] tree;
	private static long[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		tree = new Node[N + 1];
		arr = new long[N + 1];
		
		for (int i = 2; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			if (st.nextToken().equals("W")) {
				arr[i] = -Integer.parseInt(st.nextToken());
			} else {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int tmp = Integer.parseInt(st.nextToken());
			tree[tmp] = new Node(i, tree[tmp]);
		}
		System.out.println(dfs(1));
	}
	
	private static long dfs(int n) {
		for (Node next = tree[n]; next != null; next = next.next) {
			arr[n] += dfs(next.n);
		}
		return Math.max(0, arr[n]);
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
