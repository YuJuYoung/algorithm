package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem_1102 {
	
	private static int N, P;
	private static int[][] costs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		costs = new int[N][N];
		
		for (int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				costs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		String str = br.readLine();
		int start = 0;
		
		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == 'Y') {
				start += 1 << i;
			}
		}
		
		P = Integer.parseInt(br.readLine());
		
		System.out.println(bfs(start));
	}
	
	private static int bfs(int start) {
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
		Set<Integer> hs = new HashSet<>();
		
		pq.add(new int[] { start, 0 });
		
		while (!pq.isEmpty()) {
			int[] node = pq.poll();
			
			int visited = node[0];
			int cost = node[1];
			
			if (hs.contains(visited)) {
				continue;
			}
			hs.add(visited);
			
			if (isEnded(visited)) {
				return cost;
			}
			
			for (int i = 0; i < N; i++) {
				int num = visited | (1 << i);
				
				if (num == visited) {
					continue;
				}
				
				for (int j = 0; j < N; j++) {
					if (i == j || (visited | (1 << j)) != visited) {
						continue;
					}
					pq.add(new int[] { num, cost + costs[j][i] });
				}
			}
		}
		return -1;
	}
	
	private static boolean isEnded(int num) {
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			if ((num | (1 << i)) == num) {
				if (++cnt == P) {
					return true;
				}
			}
		}
		return false;
	}

}
