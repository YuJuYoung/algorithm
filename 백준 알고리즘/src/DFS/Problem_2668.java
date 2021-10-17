package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2668 {
	
	private static int[] graph;
	private static int[] visited;
	
	private static int total = 0;
	private static boolean[] cycle;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		graph = new int[N + 1];
		visited = new int[N + 1];
		cycle = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = Integer.parseInt(br.readLine());
		}
		
		int visit = -1;
		for (int i = 1; i <= N; i++) {
			if (visited[i] == 0) {
				dfs(i, visit--);
			}
		}
		
		StringBuilder sb = new StringBuilder().append(total);
		for (int i = 1; i <= N; i++) {
			if (cycle[i]) {
				sb.append('\n').append(i);
			}
		}
		System.out.println(sb);
	}
	
	private static int dfs(int n, int visit) {
		if (visited[n] != 0) {
			if (visited[n] != visit) {
				return -1;
			} else {
				return n;
			}
		}
		visited[n] = visit;
		
		if (n == graph[n]) {
			cycle[n] = true;
			total++;
		} else {
			int tmp = dfs(graph[n], visit);
			
			if (tmp != -1) {
				cycle[n] = true;
				total++;
				
				if (tmp != n) {
					return tmp;
				}
			}
		}
		return -1;
	}

}
