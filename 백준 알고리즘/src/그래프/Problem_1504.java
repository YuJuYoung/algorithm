package ±×·¡ÇÁ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1504 {
	
	private static int N, E;
	private static Node[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		graph = new Node[N + 1];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a] = new Node(b, c, graph[a]);
			graph[b] = new Node(a, c, graph[b]);
		}
		
		st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		System.out.println(getAnswer(a, b));
	}
	
	private static int getAnswer(int a, int b) {
		int toA = getMin(1, a);
		int toB = getMin(1, b);
		int AtoB = getMin(a, b);
		int AtoN = getMin(a, N);
		int BtoN = getMin(b, N);
		
		int ab = toA + AtoB + BtoN;
		int ba = toB + AtoB + AtoN;
		
		boolean pab = isPossible(toA, AtoB, BtoN);
		boolean pba = isPossible(toB, AtoB, AtoN);
		
		if (pab) {
			if (!pba) {
				return ab;
			}
		} else {
			if (pba) {
				return ba;
			}
			return -1;
		}
		return Math.min(ab, ba);
	}
	
	private static boolean isPossible(int a, int b, int c) {
		return a != -1 && b != -1 && c != -1;
	}
	
	private static int getMin(int s, int e) {
		Queue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));
		boolean[] visited = new boolean[N + 1];
		
		pq.add(new int[] { s, 0 });
		
		while (!pq.isEmpty()) {
			int[] node = pq.poll();
			int a = node[0];
			int c = node[1];
			
			if (a == e) {
				return c;
			}
			if (visited[a]) {
				continue;
			}
			visited[a] = true;
			
			for (Node next = graph[a]; next != null; next = next.next) {
				if (!visited[next.b]) {
					pq.add(new int[] { next.b, c + next.c });
				}
			}
		}
		return -1;
	}
	
	private static class Node {
		int b, c;
		Node next;
		
		public Node(int b, int c, Node next) {
			this.b = b;
			this.c = c;
			this.next = next;
		}
	}

}
