package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_8872 {
	
	private static int N, M, L;
	
	private static int[] group, groupMax;
	private static Node[] graph;

	public static void main(String[] args) throws IOException {
		setVar();
		System.out.println(solve());
		for (int num : groupMax) {
			System.out.println(num);
		}
	}
	
	private static void setVar() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		groupMax = new int[N - M + 1];
		group = new int[N];
		graph = new Node[N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			
			graph[A] = new Node(B, T, graph[A]);
			graph[B] = new Node(A, T, graph[B]);
		}
	}
	
	private static int solve() {
		int groupNum = 1;
		
		for (int i = 0; i < N; i++) {
			if (group[i] == 0) {
				group[i] = groupNum++;
			}
			groupMax[group[i]] = dfs(i, -1, group[i]);
		}
		
		int ans = L * (N - M - 1);
		
		for (int i = 1; i <= N - M; i++) {
			ans += groupMax[i];
		}
		return ans;
	}
	
	private static int dfs(int n, int last, int groupNum) {
		group[n] = groupNum;
		
		int max = 0;
		
		for (Node node = graph[n]; node != null; node = node.next) {
			if (node.n == last) {
				continue;
			}
			
			if (node.cache == 0) {
				node.cache = dfs(node.n, n, groupNum) + node.t;
			}
			max = Math.max(max, node.cache);
		}
		return max;
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
