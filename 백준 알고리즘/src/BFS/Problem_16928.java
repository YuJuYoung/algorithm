package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_16928 {
	
	private static int[] arr = new int[100];
	private static boolean[] visited = new boolean[100];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a] = b;
		}
		System.out.println(bfs());
	}
	
	private static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		
		int time = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				int n = q.poll();
				
				for (int i = 1; i <= 6; i++) {
					int nt = n + i;
					
					if (nt == 100 || arr[nt] == 100) {
						return time;
					}
					if (arr[nt] == 0 && !visited[nt]) {
						q.add(nt);
						visited[nt] = true;
					} else {
						if (!visited[arr[nt]]) {
							q.add(arr[nt]);
							visited[arr[nt]] = true;
						}
					}
				}
			}
			time++;
		}
		return -1;
	}

}
