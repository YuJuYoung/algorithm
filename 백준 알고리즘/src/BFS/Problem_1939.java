package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1939 {
	
	private static Node[] graph;
	private static int[] arr;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new Node[N + 1];
		arr = new int[M];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			graph[A] = new Node(B, graph[A], C);
			graph[B] = new Node(A, graph[B], C);
			arr[i] = C;
		}
		Arrays.sort(arr);
		
		st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int left = 0, right = M - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			
			visited = new boolean[N + 1];
			if (bfs(A, B, arr[mid])) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(arr[right]);
	}
	
	private static boolean bfs(int A, int B, int C) {
		Queue<Integer> q = new LinkedList<>();
		q.add(A);
		visited[A] = true;
		
		while (!q.isEmpty()) {
			int n = q.poll();
			if (n == B) {
				return true;
			}
			
			for (Node next = graph[n]; next != null; next = next.next) {
				if (!visited[next.n] && next.c >= C) {
					q.add(next.n);
					visited[next.n] = true;
				}
			}
		}
		return false;
	}
	
	private static class Node {
		int n, c;
		Node next;
		
		public Node(int n, Node node, int c) {
			this.n = n;
			next = node;
			this.c = c;
		}
	}

}
