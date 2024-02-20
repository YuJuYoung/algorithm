package 세그먼트트리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_2042 {
	
	private static int N, M, K;
	private static long[] arr, tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new long[N];
		tree = new long[N * 4];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		init(0, N - 1, 1);
		
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if (a == 1) {
				change(0, N - 1, 1, b - 1, c - arr[b - 1]);
				arr[b - 1] = c;
			} else {
				bw.write(get(0, N - 1, 1, b - 1, (int) c - 1) + "\n");
			}
		}
		bw.close();
	}
	
	private static long init(int l, int r, int node) {
		if (l == r) {
			return tree[node] = arr[l];
		}
		int m = (l + r) / 2;
		
		long left = init(l, m, node * 2);
		long right = init(m + 1, r, node * 2 + 1);
		
		return tree[node] = left + right;
	}
	
	private static void change(int l, int r, int node, int idx, long add) {
		if (idx < l || r < idx) {
			return;
		}
		
		if (l < r) {
			int m = (l + r) / 2;
			
			change(l, m, node * 2, idx, add);
			change(m + 1, r, node * 2 + 1, idx, add);
		}
		tree[node] += add;
	}
	
	private static long get(int l, int r, int node, int b, int c) {
		if (c < l || r < b) {
			return 0;
		}
		if (b <= l && r <= c) {
			return tree[node];
		}
		int m = (l + r) / 2;
		
		long left = get(l, m, node * 2, b, c);
		long right = get(m + 1, r, node * 2 + 1, b, c);
		
		return left + right;
	}

}
