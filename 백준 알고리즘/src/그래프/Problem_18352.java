package ±×·¡ÇÁ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_18352 {
	
	private static int N, M, K, X;
	private static Node[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		graph = new Node[N + 1];
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph[A] = new Node(B, graph[A]);
		}
		System.out.print(getAnswer());
	}
	
	private static String getAnswer() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		
		q.add(X);
		visited[X] = true;
		
		while (!q.isEmpty() && K-- > 0) {
			int size = q.size();
			
			while (size-- > 0) {
				int n = q.poll();
				
				for (Node next = graph[n]; next != null; next = next.next) {
					if (!visited[next.n]) {
						q.add(next.n);
						visited[next.n] = true;
					}
				}
			}
		}
		
		if (q.isEmpty()) {
			return "-1\n";
		}
		int[] arr = new int[q.size()];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = q.poll();
		}
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		
		for (int n : arr) {
			sb.append(n).append("\n");
		}
		return sb.toString();
	}
	
	private static class Node {
		int n;
		Node next;
		
		public Node(int n, Node node) {
			this.n = n;
			next = node;
		}
	}

}
