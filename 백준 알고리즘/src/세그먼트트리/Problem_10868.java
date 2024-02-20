package 세그먼트트리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_10868 {
	
	private static int N, M;
	private static int[] arr, cache;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		cache = new int[N * 4];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		init(0, N - 1, 1);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			bw.write(getMin(0, N - 1, a - 1, b - 1, 1) + "\n");
		}
		
		bw.close();
	}
	
	private static int init(int l, int r, int idx) {
		if (l == r) {
			return cache[idx] = arr[l];
		}
		int m = (l + r) / 2;
		
		int leftMin = init(l, m, idx * 2);
		int rightMin = init(m + 1, r, idx * 2 + 1);
		
		return cache[idx] = Math.min(leftMin, rightMin);
	}
	
	private static int getMin(int l, int r, int a, int b, int idx) {
		if (l > b || r < a) {
			return Integer.MAX_VALUE;
		}
		if (l >= a && r <= b) {
			return cache[idx];
		}
		int m = (l + r) / 2;
		
		int leftMin = getMin(l, m, a, b, idx * 2);
		int rightMin = getMin(m + 1, r, a, b, idx * 2 + 1);
		
		return Math.min(leftMin, rightMin);
	}

}
