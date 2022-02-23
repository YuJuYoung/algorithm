package ±×·¡ÇÁ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_5719 {
	
	private static int N, M, S, D;
	private static Node[] graph;
	
	private static int[] dist;
	private static boolean[][] blocked;
	private static Parent[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			if ((N = Integer.parseInt(st.nextToken())) == 0) {
				break;
			}
			M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			S = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			graph = new Node[N];
			
			blocked = new boolean[N][N];
			parents = new Parent[N];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int U = Integer.parseInt(st.nextToken());
				int V = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				
				graph[U] = new Node(V, P, graph[U]);
			}
			for (int i = 0; i < N; i++) {
				parents[i] = new Parent();
			}
			
			bfs();
			dfs(D);
			bfs();
			
			if (dist[D] == 0) {
				bw.write("-1\n");
			} else {
				bw.write(dist[D] - 1 + "\n");
			}
		}
		bw.close();
	}
	
	private static void dfs(int n) {
		if (n == S) {
			return;
		}
		
		for (int parent : parents[n].list) {
			if (!blocked[parent][n]) {
				blocked[parent][n] = true;
				dfs(parent);
			}
		}
	}
	
	private static void bfs() {
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
			return Integer.compare(a[2], b[2]);
		});
		pq.add(new int[] { S, S, 1 });
		
		dist = new int[N];
		
		while (!pq.isEmpty()) {
			int[] node = pq.poll();
			
			int last = node[0];
			int n = node[1];
			int sum = node[2];
			
			if (dist[n] == 0) {
				dist[n] = sum;
				
				for (Node next = graph[n]; next != null; next = next.next) {
					int nextSum = sum + next.p;
					
					if (!blocked[n][next.n]) {
						if (dist[next.n] == 0 || dist[next.n] == nextSum) {
							pq.add(new int[] { n, next.n, sum + next.p });
						}
					}
				}
			} else {
				if (dist[n] < sum) {
					continue;
				}
			}
			parents[n].list.add(last);
		}
	}
	
	private static class Node {
		int n, p;
		Node next;
		
		public Node(int n, int p, Node next) {
			this.n = n;
			this.p = p;
			this.next = next;
		}
	}
	
	private static class Parent {
		List<Integer> list = new ArrayList<>();
	}

}
