package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2482 {
	
	private static final int MOD = 1000000003;
	private static int[][] cache;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		cache = new int[N][K + 1];
		
		if (K == 1) {
			System.out.println(N);
			return;
		}
		
		cache[1][1] = 1;
		for (int i = 2; i < N; i++) {
			cache[i][1] = i;
			
			for (int j = 2; j <= K; j++) {
				cache[i][j] = (cache[i - 2][j - 1] + cache[i - 1][j]) % MOD;
			}
		}
		System.out.println((cache[N - 3][K - 1] + cache[N - 1][K]) % MOD);
	}

}
