package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1783 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		long sum;
		
		if (N > 2 && M > 6 ) {
			sum = M - 2;
		} else if (N == 1) {
			sum = 1;
		} else if (N == 2) {
			sum = (M - 1) / 2 + 1;
			
			if (sum > 4) {
				sum = 4;
			}
		} else {
			sum = M > 4 ? 4 : M;
		}
		System.out.println(sum);
	}

}
