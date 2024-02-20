package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1654 {
	
	private static int K, N;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[K];
		
		int max = 1;
		
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		System.out.println(binarysearch(max));
	}
	
	private static long binarysearch(long e) {
		long s = 1;
		
		while (s < e) {
			long m = (s + e) / 2 + 1;
			
			if (isPossible(m)) {
				s = m;
			} else {
				e = m - 1;
			}
		}
		return s;
	}
	
	private static boolean isPossible(long len) {
		long sum = 0;
		
		for (int i = 0; i < K; i++) {
			sum += arr[i] / len;
			
			if (sum >= N) {
				return true;
			}
		}
		return false;
	}

}
