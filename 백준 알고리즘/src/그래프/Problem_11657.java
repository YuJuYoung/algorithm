package ±×·¡ÇÁ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_11657 {
	
	private static int N, M;
	private static Node[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new Node[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			graph[A] = new Node(B, C, graph[A]);
		}
		
		int[] answer = getAnswer();
		
		if (answer == null) {
			System.out.println(-1);
		} else {
			StringBuilder sb = new StringBuilder();
			
			for (int i = 2; i <= N; i++) {
				if (answer[i] == Integer.MAX_VALUE) {
					sb.append(-1);
				} else {
					sb.append(answer[i]);
				}
				sb.append("\n");
			}
			System.out.print(sb);
		}
	}
	
	private static int[] getAnswer() {
		int[] answer = new int[N + 1];
		
		Arrays.fill(answer, 2, N + 1, Integer.MAX_VALUE);
		
		for (int t = 0; t < N - 1; t++) {
			int[] temp = new int[N + 1];
			
			for (int i = 1; i <= N; i++) {
				temp[i] = answer[i];
			}
			
			for (int n = 1; n <= N; n++) {
				if (answer[n] == Integer.MAX_VALUE) {
					continue;
				}
				
				for (Node next = graph[n]; next != null; next = next.next) {
					temp[next.n] = Math.min(temp[next.n], answer[n] + next.c);
				}
			}
			answer = temp;
		}
		return check(answer) ? answer : null;
	}
	
	private static boolean check(int[] answer) {
		for (int n = 1; n <= N; n++) {
			if (answer[n] == Integer.MAX_VALUE) {
				continue;
			}
			
			for (Node next = graph[n]; next != null; next = next.next) {
				if (answer[next.n] > answer[n] + next.c) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static class Node {
		int n, c;
		Node next;
		
		public Node(int n, int c, Node next) {
			this.n = n;
			this.c = c;
			this.next = next;
		}
	}

}
