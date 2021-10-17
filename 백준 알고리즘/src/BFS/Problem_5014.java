package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_5014 {
	
	private static boolean[] visited;
	private static int F, S, G, U, D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		visited = new boolean[F + 1];
		System.out.println(bfs());
	}
	
	private static String bfs() {
		Queue<Elevator> q = new LinkedList<>();
		q.add(new Elevator(0, S));
		visited[S] = true;
		
		while (!q.isEmpty()) {
			Elevator tmp = q.poll();
			if (tmp.n == G) {
				return Integer.toString(tmp.count);
			}
			int u = tmp.n + U;
			int d = tmp.n - D;
			if (u <= F && !visited[u]) {
				q.add(new Elevator(tmp.count + 1, u));
				visited[u] = true;
			}
			if (d >= 1 && !visited[d]) {
				q.add(new Elevator(tmp.count + 1, d));
				visited[d] = true;
			}
		}
		return "use the stairs";
	}
	
	private static class Elevator {
		int count, n;
		
		public Elevator(int count, int n) {
			this.count = count;
			this.n = n;
		}
	}

}
