package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1260 {
	
	private static Node[] tree;
	private static boolean[] visited;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		tree = new Node[N + 1];
		
		for (int i = 0; i <= N; i++) {
			tree[i] = new Node();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u].add(v);
			tree[v].add(u);
		}
		for (Node node : tree) {
			node.sort();
		}
		
		reset(N);
		dfs(V);
		System.out.println(sb);
		reset(N);
		bfs(V);
		System.out.println(sb);
	}
	
	private static void dfs(int u) {
		visited[u] = true;
		append(u);
		
		for (int v : tree[u].list) {
			if (!visited[v]) {
				dfs(v);
			}
		}
	}
	
	private static void bfs(int V) {
		Queue<Integer> q = new LinkedList<>();
		q.add(V);
		visited[V] = true;
		append(V);
		
		while (!q.isEmpty()) {
			int u = q.poll();
			
			for (int v : tree[u].list) {
				if (!visited[v]) {
					q.add(v);
					visited[v] = true;
					append(v);
				}
			}
		}
	}
	
	private static void append(int n) {
		sb.append(n).append(" ");
	}
	
	private static void reset(int N) {
		visited = new boolean[N + 1];
		sb = new StringBuilder();
	}
	
	private static class Node {
		List<Integer> list = new ArrayList<>();
		
		public void add(int n) {
			list.add(n);
		}
		
		public void sort() {
			Collections.sort(list);
		}
	}
}
