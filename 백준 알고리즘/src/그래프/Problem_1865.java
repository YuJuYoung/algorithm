package ±×·¡ÇÁ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_1865 {
	
	private static int N, M, W;
	private static Node[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int TC = Integer.parseInt(br.readLine()); TC > 0; TC--) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			graph = new Node[N + 1];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				
				graph[s] = new Node(e, t, graph[s]);
				graph[e] = new Node(s, t, graph[e]);
			}
			
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				
				graph[s] = new Node(e, -t, graph[s]);
			}
			
			bw.write(solve());
			bw.newLine();
		}
		bw.close();
	}
	
	private static String solve() {
		int[] time = new int[N + 1];
		boolean updated = false;
		
		for (int i = 0; i < N; i++) {
			int[] temp = new int[N + 1];
			updated = false;
			
			for (int j = 1; j <= N; j++) {
				temp[j] = time[j];
			}
			
			for (int n = 1; n <= N; n++) {
				for (Node next = graph[n]; next != null; next = next.next) {
					int nt = temp[n] + next.t;
					
					if (temp[next.n] > nt) {
						temp[next.n] = nt;
						updated = true;
					}
				}
			}
			
			if (!updated) {
				break;
			}
			time = temp;
		}
		return updated ? "YES" : "NO";
	}
	
	private static class Node {
		int n, t;
		Node next;
		
		public Node(int n, int t, Node next) {
			this.n = n;
			this.t = t;
			this.next = next;
		}
	}

}
