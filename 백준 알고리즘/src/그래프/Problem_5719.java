package ±×·¡ÇÁ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_5719 {
	
	private static int N, M, S, D;
	private static Node[] graph;

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
			
			graph = new Node[N + 1];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int U = Integer.parseInt(st.nextToken());
				int V = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				
				graph[U] = new Node(V, P, graph[U]);
			}
			bw.write(bfs() + "\n");
		}
		bw.close();
	}
	
	private static int bfs() {
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
		pq.add(new int[] { S, 0 });
		
		int min = Integer.MAX_VALUE;
		
		while (!pq.isEmpty()) {
			int[] node = pq.poll();
			
			int n = node[0];
			int sum = node[1];
			
			if (n == D) {
				if (min < sum) {
					return sum;
				}
				min = sum;
			} else {
				for (Node next = graph[n]; next != null; next = next.next) {
					if (!next.passed) {
						pq.add(new int[] { next.n, sum + next.p });
					}
				}
			}
		}
		return -1;
	}
	
	private static class Node {
		int n, p;
		boolean passed = false;
		Node next;
		
		public Node(int n, int p, Node next) {
			this.n = n;
			this.p = p;
			this.next = next;
		}
	}

}
