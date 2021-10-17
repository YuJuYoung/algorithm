package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_10265 {
	
	private static int n, k;
	private static Node[] nodes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		if (n <= k) {
			System.out.println(n);
		} else {
			nodes = new Node[n + 1];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 1; i <= n; i++) {
				int num = Integer.parseInt(st.nextToken());
				nodes[num] = new Node(i, nodes[num]);
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
