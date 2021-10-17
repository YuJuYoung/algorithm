package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_13913 {
	
	private static boolean[] visited;
	private static int[] from;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		from = new int[100001];
		visited = new boolean[100001];
		
		System.out.println(bfs(N, K));
	}
	
	private static StringBuilder bfs(int N, int K) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		
		visited[N] = true;
		from[N] = -1;
		
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				int n = q.poll();
				if (n == K) {
					sb.append(time).append("\n");
					
					int[] answer = new int[time + 1];
					int index = time;
					
					while (n != -1) {
						answer[index--] = n;
						n = from[n];
					}
					for (int tmp : answer) {
						sb.append(tmp).append(" ");
					}
					return sb;
				}
				int[] arr = { n - 1, n + 1, n * 2 };
				
				if (arr[0] > 0 && !visited[arr[0]]) {
					q.add(arr[0]);
					visited[arr[0]] = true;
					from[arr[0]] = n;
				}
				if (n > K) {
					continue;
				}
				
				for (int i = 1; i < 3; i++) {
					if (arr[i] <= 100000 && !visited[arr[i]]) {
						q.add(arr[i]);
						visited[arr[i]] = true;
						from[arr[i]] = n;
					}
				}
			}
			time++;
		}
		return null;
	}

}
