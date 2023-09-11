package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_10217 {
	
	private static int N, M, K;
	private static Ticket[] tickets = null;

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
		int[][] dp = new int[N][M + 1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= M; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		dp[0][0] = 0;
		
		boolean[] visited = new boolean[N];
		
		PriorityQueue<PQNode> pq = new PriorityQueue<>();
		pq.add(new PQNode(0, 0));
		
		// 다익스트라
		while (!pq.isEmpty()) {
			PQNode node = pq.poll();
			int u = node.u;
			
			if (visited[u]) {
				continue;
			}
			visited[u] = true;
			
			for (Ticket ticket = tickets[u]; ticket != null; ticket = ticket.another) {
				int min = Integer.MAX_VALUE;
				int v = ticket.v;
				
				for (int c = 0; c + ticket.c <= M; c++) {
					if (dp[u][c] == Integer.MAX_VALUE) {
						continue;
					}
					int nc = c + ticket.c;
					int nd = dp[u][c] + ticket.d;
					
					dp[v][nc] = Math.min(dp[v][nc], nd);
					min = Math.min(min, dp[v][nc]);
				}
				pq.add(new PQNode(v, min));
			}
		}
		Arrays.sort(dp[N - 1]);
		return (dp[N - 1][0] == Integer.MAX_VALUE ? "Poor KCM" : dp[N - 1][0]) + "\n";
	}
	
	private static class Ticket {
		int v, c, d;
		Ticket another;
		
		public Ticket(int v, int c, int d, Ticket ticket) {
			this.v = v;
			this.c = c;
			this.d = d;
			another = ticket;
		}
	}
	
	private static class PQNode implements Comparable<PQNode> {
		int u, d;
		
		public PQNode(int u, int d) {
			this.u = u;
			this.d = d;
		}

		@Override
		public int compareTo(PQNode o) {
			return Integer.compare(d, o.d);
		}
	}
	
}