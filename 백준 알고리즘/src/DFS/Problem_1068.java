package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1068 {
	
	private static Node[] tree;
	private static int delete, answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		tree = new Node[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = 0;
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			if (n == -1) {
				start = i;
			} else {
				tree[n] = new Node(i, tree[n]);
			}
		}
		delete = Integer.parseInt(br.readLine());
		
		if (start == delete) {
			System.out.println(0);
		} else {
			dfs(start);
			System.out.println(answer);
		}
	}
	
	private static void dfs(int n) {
		boolean haveNode = false;
		
		for (Node next = tree[n]; next != null; next = next.next) {
			if (next.n == delete) {
				continue;
			}
			dfs(next.n);
			haveNode = true;
		}
		if (!haveNode) {
			answer++;
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
