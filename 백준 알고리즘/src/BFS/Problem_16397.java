package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_16397 {
	
	private static final int MAX = 100000;
	private static int N, T, G;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs());
	}
	
	private static String bfs() {
		boolean[] visited = new boolean[MAX];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visited[N] = true;
		
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				int n = q.poll();
				if (n == G) {
					return Integer.toString(time);
				}
				
				if (n + 1 < MAX && !visited[n + 1]) {
					q.add(n + 1);
					visited[n + 1] = true;
				}
				if (n != 0 && n * 2 < MAX) {
					n *= 2;
					
					int tmp = MAX;
					while (n / tmp == 0) {
						tmp /= 10;
					}
					tmp = (n / tmp - 1) * tmp + n % tmp;
					
					if (!visited[tmp]) {
						q.add(tmp);
						visited[tmp] = true;
					}
				}
			}
			if (++time > T) {
				break;
			}
		}
		return "ANG";
	}

}
