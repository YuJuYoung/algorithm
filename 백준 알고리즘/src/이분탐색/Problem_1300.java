package ÀÌºÐÅ½»ö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1300 {
	
	private static long N, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Long.parseLong(br.readLine());
		k = Long.parseLong(br.readLine());
		
		System.out.println(binarysearch(1, N * N, k));
	}
	
	private static long binarysearch(long s, long e, long k) {
		while (s < e) {
			long m = (s + e) / 2;
			
			long[] count = getCount(m);
			long tot = count[0];
			long same = count[1];
			
			if (tot < k) {
				s = m + 1;
			} else {
				if (tot - same < k) {
					return m;
				}
				e = m;
			}
		}
		return s;
	}
	
	private static long[] getCount(long m) {
		long[] count = new long[2];
		
		for (int i = 1; i <= N && i <= m; i++) {
			count[0] += Math.min(N, m / i);
			
			if (m % i == 0 && m / i <= N) {
				count[1]++;
			}
		}
		return count;
	}

}
