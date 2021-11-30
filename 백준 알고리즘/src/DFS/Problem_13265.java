package DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_13265 {
	
	private static int n, cntOfCircle;
	
	private static Node[] graph;
	private static int[] colors;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
			setFields(br);
			
			boolean possible = true;
			
			for (int i = 1; i <= n; i++) {
				if (colors[i] != 0) {
					continue;
				}
				
				if (!dfs(i, 0, 1)) {
					possible = false;
					break;
				}
				if (cntOfCircle == n) {
					break;
				}
			}
			bw.write(possible ? "possible\n" : "impossible\n");
		}
		bw.close();
	}
	
	private static void setFields(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		cntOfCircle = 0;
		
		graph = new Node[n + 1];
		colors = new int[n + 1];
		
		for (int m = Integer.parseInt(st.nextToken()); m > 0; m--) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a] = new Node(b, graph[a]);
			graph[b] = new Node(a, graph[b]);
		}
	}
	
	private static boolean dfs(int n, int last, int color) {
		colors[n] = color;
		cntOfCircle++;
		
		int nextColor = toggle(color);
		
		for (Node node = graph[n]; node != null; node = node.next) {
			if (node.n == last) {
				continue;
			}
			
			if (colors[node.n] != 0) {
				if (colors[node.n] == colors[n]) {
					return false;
				}
			} else {
				if (!dfs(node.n, n, nextColor)) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static int toggle(int color) {
		return color == 1 ? 2 : 1;
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
