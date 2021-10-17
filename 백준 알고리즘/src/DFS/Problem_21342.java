package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_21342 {
	
	private static Node[] tree;
	private static int[] count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		tree = new Node[n + 1];
		count = new int[n + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			tree[A] = new Node(B, tree[A]);
			tree[B] = new Node(A, tree[B]);
		}
		
		int max = -1, v = 0;
		for (int i = 1; i <= n; i++) {
			int tmp = dfs(i, 0);
			
			if (tmp > max) {
				max = tmp;
				v = i;
			}
		}
		System.out.println(max + " " + v);
	}
	
	private static int dfs(int n, int last) {
		int max = 0;
		
		for (Node next = tree[n]; next != null; next = next.next) {
			if (next.n != last) {
				if (next.max == -1) {
					next.max = dfs(next.n, n);
				}
				
				if (max < next.max) {
					max = next.max;
				}
			}
		}
		return max + count[n];
	}
	
	private static class Node {
		int n, max = -1;
		Node next;
		
		public Node(int n, Node next) {
			this.n = n;
			this.next = next;
		}
	}

}
