package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1300 {
	
	private static int N, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		System.out.println(binarysearch(1, k, k));
	}
	
	private static int binarysearch(int s, int e, int k) {
		while (s < e) {
			int m = (s + e) / 2;
			int count = getCount(m);
			
			if (count < k) {
				s = m + 1;
			} else {
				e = m;
			}
		}
		return s;
	}
	
	private static int getCount(int m) {
		int count = 0;
		
		for (int i = 1; i <= N && i <= m; i++) {
			count += Math.min(N, m / i);
		}
		return count;
	}

}
