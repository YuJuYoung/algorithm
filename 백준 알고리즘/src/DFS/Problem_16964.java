package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem_16964 {
	
	private static int N;
	private static Node[] graph;

	private static int[] arr;
	private static int index = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		graph = new Node[N + 1];
		arr = new int[N];
		
		for (int i = 0; i <= N; i++) {
			graph[i] = new Node();
		}
		graph[0].s.add(1);
		
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].s.add(v);
			graph[v].s.add(u);
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(dfs(0) ? 1 : 0);
	}
	
	private static boolean dfs(int n) {
		if (index == N) {
			return true;
		}
		
		while (graph[n].s.contains(arr[index])) {
			if (dfs(arr[index++])) {
				return true;
			}
		}
		return false;
	}
	
	private static class Node {
		Set<Integer> s;
		
		public Node() {
			s = new HashSet<>();
		}
	}

}
