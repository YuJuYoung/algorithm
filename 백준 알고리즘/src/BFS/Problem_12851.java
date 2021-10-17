package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_12851 {
	
	private static int count = 1, min = 0;
	private static int[] cache;
	private static Queue<Integer> q = new LinkedList<>();
	private static int time = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if (N >= K) {
			System.out.println(N - K + " " + count);
			return;
		}
		cache = new int[K + 2];
		
		bfs(N, K);
		System.out.println(min + "\n" + count);
	}
	
	private static void bfs(int N, int K) {
		q.add(N);
		
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				int n = q.poll();
				
				if (n == K) {
					min = time;
					while (!q.isEmpty()) {
						if (q.poll() == K) {
							count++;
						}
					}
					return;
				}
				
				if (n != 0) {
					check(n - 1);
				}
				if (n * 2 <= K + 1) {
					check(n * 2);
				}
				if (n + 1 <= K) {
					check(n + 1);
				}
			}
			time++;
		}
		
	}
	
	private static void check(int n) {
		if (cache[n] == 0 || cache[n] == time) {
			q.add(n);
			cache[n] = time;
		}
	}

}
