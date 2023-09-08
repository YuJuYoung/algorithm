package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_10217 {
	
	private static int N, M, K;
	private static Ticket[] tickets = null;
	private static int[][] distances = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
			StringTokenizer st = null;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			tickets = new Ticket[N];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()) - 1;
				int v = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				tickets[u] = new Ticket(v, c, d, tickets[u]);
			}
			bw.write(solve());
		}
		bw.flush();
		bw.close();
	}
	
	private static String solve() {
		distances = new int[M + 1][N];
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < N; j++) {
				distances[i][j] = Integer.MAX_VALUE;
			}
		}
		distances[0][0] = 0;
		
		PriorityQueue<PQNode> pq = new PriorityQueue<>();
		pq.add(new PQNode(0, 0, 0));
		
		int[][] minDistances = new int[N][2];
		for (int i = 1; i < N; i++) {
			minDistances[i][0] = minDistances[i][1] = Integer.MAX_VALUE;
		}
		
		// 다익스트라
		while (!pq.isEmpty()) {
			PQNode node = pq.poll();
			
			if (node.start == N - 1) {
				return node.d + "\n";
			}
			
			if (compareDistance(node.c, node.d, minDistances[node.start][0], minDistances[node.start][1]) > 0) {
				continue;
			}

			for (Ticket ticket = tickets[node.start]; ticket != null; ticket = ticket.next) {
				int to = ticket.to;
				int nc = node.c + ticket.c;
				int nd = node.d + ticket.d;
				
				if (nc <= M && distances[nc][to] > nd) {
					distances[nc][to] = nd;
					pq.add(new PQNode(to, nc, nd));
					
					if (compareDistance(nc, nd, minDistances[to][0], minDistances[to][1]) < 0) {
						minDistances[to][0] = nc;
						minDistances[to][1] = nd;
					}
				}
			}
		}
		return "Poor KCM\n";
	}
	
	private static int compareDistance(int n1, int d1, int n2, int d2) {
		if (n1 == n2 && d1 == d2) {
			return 0;
		}
		if (n1 <= n2 && d1 <= d2) {
			return -1;
		}
		if (n1 >= n2 && d1 >= d2) {
			return 1;
		}
		return 0;
	}
	
	private static class Ticket {
		int to, c, d;
		Ticket next;
		
		public Ticket(int to, int c, int d, Ticket ticket) {
			this.to = to;
			this.c = c;
			this.d = d;
			next = ticket;
		}
	}
	
	private static class PQNode implements Comparable<PQNode> {
		int start, c, d;
		
		public PQNode(int start, int c, int d) {
			this.start = start;
			this.c = c;
			this.d = d;
		}

		@Override
		public int compareTo(PQNode o) {
			return Integer.compare(d, o.d);
		}
	}
	
}
