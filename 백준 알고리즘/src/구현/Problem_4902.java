package ±¸Çö;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_4902 {
	
	private static int N;
	private static int[][] arr, cache;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = 1;
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			if ((N = Integer.parseInt(st.nextToken())) == 0) {
				break;
			}
			arr = new int[N][N * 2 - 1];
			cache = new int[N][N * 2 - 1];
			
			for (int i = 0; i < N; i++) {
				cache[i][0] = arr[i][0] = Integer.parseInt(st.nextToken());
				
				for (int j = 1; j < i * 2 - 1; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					cache[i][j] = cache[i][j - 1] + arr[i][j];
				}
			}
			bw.write("%d. %d\n", t++, getMax());
		}
		bw.close();
	}
	
	private static int getMax() {
		int max = 0;
		
		for (int i = 1; i <= N; i++) {
			
		}
		return max;
	}

}
