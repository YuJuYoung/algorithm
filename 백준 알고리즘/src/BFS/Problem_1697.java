package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1697 {
	
	private static int answer = Integer.MAX_VALUE;
	private static int[] cache;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		cache = new int[K];
		
		dfs(N, K, 0);
		System.out.println(answer);
	}
	
	private static void dfs(int N, int K, int count) {
		if (N >= K) {
			count += N - K;
			
			if (answer > count) {
				answer = count;
			}
			return;
		}
		if (N < 0 || (cache[N] != 0 && cache[N] <= count)) {
			return;
		}
		cache[N] = count;
		
		dfs(N + 1, K, count + 1);
		dfs(N * 2, K, count + 1);
		dfs(N - 1, K, count + 1);
	}

}
