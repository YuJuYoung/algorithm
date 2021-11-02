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
	private static int[][] airports;
	private static Ticket[] tickets;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			airports = new int[N][M];
			tickets = new Ticket[N + 1];
			
			for (int K = Integer.parseInt(st.nextToken()); K > 0; K--) {
				st = new StringTokenizer(br.readLine());
				
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				tickets[u] = new Ticket(v, c, d, tickets[u]);
			}
			bw.write(bfs());
		}
		bw.close();
	}
	
	private static String bfs() {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
		
		q.add(new int[] { 1, 0, 0 });
		airports[1][0] = -1;
		
		int min = Integer.MAX_VALUE;
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int u = tmp[0];
			int c = tmp[1];
			int d = tmp[2];
			
			for (Ticket ticket = tickets[u]; ticket != null; ticket = ticket.next) {
				int nc = c + ticket.c;
				
				if (nc > M) {
					continue;
				}
				int nd = d + ticket.d;
				
				if (min <= nd) {
					continue;
				}
				int v = ticket.v;
				
				if (v == N) {
					min = nd;
					continue;
				}
				if (nc == M) {
					continue;
				}
				if (airports[v][nc] != 0 && airports[v][nc] <= nd) {
					continue;
				}
				
				q.add(new int[] { v, nc, nd });
				airports[v][nc] = nd;
			}
		}
		
		if (min == Integer.MAX_VALUE) {
			return "Poor KCM\n";
		}
		return (min + "\n");
	}
	
	private static class Ticket {
		int v, c, d;
		Ticket next;
		
		public Ticket(int v, int c, int d, Ticket ticket) {
			this.v = v;
			this.c = c;
			this.d = d;
			next = ticket;
		}
	}

}
