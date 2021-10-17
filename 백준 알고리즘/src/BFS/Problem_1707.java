package BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1707 {
	
	private static Node[] graph;
	private static int[] cache;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int K = Integer.parseInt(br.readLine()); K > 0; K--) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			graph = new Node[V + 1];
			cache = new int[V + 1];
			
			while (E-- > 0) {
				st = new StringTokenizer(br.readLine());
				
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				graph[u] = new Node(v, graph[u]);
				graph[v] = new Node(u, graph[v]);
		    }
			
			boolean flag = false;
			for (int i = 1; i <= V; i++) {
				if (cache[i] == 0) {
					if (!bfs(i)) {
						flag = true;
						break;
					}
				}
			}
			bw.write(flag ? "NO\n" : "YES\n");
		}
		bw.close();
    }
	
	private static boolean bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		cache[n] = 1;
		
		int tmp = 2;
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				n = q.poll();
				
				for (Node next = graph[n]; next != null; next = next.next) {
					if (cache[next.n] == 0) {
						q.add(next.n);
						cache[next.n] = tmp;
					} else {
						if (cache[next.n] != tmp) {
							return false;
						}
					}
				}
			}
			tmp = tmp == 2 ? 1 : 2;
		}
		return true;
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
