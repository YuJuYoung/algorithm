package ±×·¡ÇÁ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1753 {
	
	private static Node[] nodes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		nodes = new Node[V + 1];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			nodes[u] = new Node(v, w, nodes[u]);
		}
		
		int[] result = bfs(V, K);
		
		for (int i = 1; i <= V; i++) {
			if (i == K) {
				bw.write(0 + "\n");
			} else {
				int num = result[i];
				
				if (num == 0) {
					bw.write("INF\n");
				} else {
					bw.write(num + "\n");
				}
			}
		}
		bw.close();
	}
	
	private static int[] bfs(int V, int K) {
		Queue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));
		
		int[] result = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		
		pq.add(new int[] { K, 0 });
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int u = cur[0];
			int w = cur[1];
			
			if (visited[u]) {
				continue;
			}
			result[u] = w;
			visited[u] = true;
			
			for (Node node = nodes[u]; node != null; node = node.next) {
				if (!visited[node.v]) {
					pq.add(new int[] { node.v, w + node.w });
				}
			}
		}
		return result;
	}
	
	private static class Node {
		int v, w;
		Node next;
		
		public Node(int v, int w, Node node) {
			this.v = v;
			this.w = w;
			next = node;
		}
	}

}
