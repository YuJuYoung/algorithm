package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_10217 {
	
	private static int N, M;
	private static int[][] dp;
	private static Node[] nodes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dp = new int[N + 1][M + 1];
			nodes = new Node[N + 1];
			
			for (int K = Integer.parseInt(st.nextToken()); K > 0; K--) {
				st = new StringTokenizer(br.readLine());
				
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				
				nodes[u] = new Node(v, c, d, nodes[u]);
			}
			bw.write(bfs());
		}
		bw.close();
	}
	
	private static String bfs() {
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
		
		pq.add(new int[] { 1, 0, 1 });
		dp[1][0] = 1;
		
		int min = Integer.MAX_VALUE;
		
		while (!pq.isEmpty()) {
			int[] arr = pq.poll();
			int u = arr[0];
			int c = arr[1];
			int d = arr[2];
			
			if (u == N) {
				min = d;
				continue;
			}
			if (c == M) {
				continue;
			}
			
			for (Node node = nodes[u]; node != null; node = node.next) {
				int v = node.v;
				int nc = c + node.c;
				int nd = d + node.d;
				
				if (nc > M || nd >= min) {
					continue;
				}
				if (dp[v][nc] != 0 && nd >= dp[v][nc]) {
					continue;
				}
				
				pq.add(new int[] { v, nc, nd });
				dp[v][nc] = nd;
			}
		}
		return min == Integer.MAX_VALUE ? "Poor KCM\n" : ((min - 1) + "\n");
	}
	
	private static class Node {
		int v, c, d;
		Node next;
		
		public Node(int v, int c, int d, Node node) {
			this.v = v;
			this.c = c;
			this.d = d;
			next = node;
		}
	}

}
