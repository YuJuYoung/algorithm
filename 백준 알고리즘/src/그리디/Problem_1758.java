package 그리디;

import java.io.*;
import java.util.Arrays;

public class Problem_1758 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] tips = new long[N];
		
		for (int i = 0; i < N; i++) {
			tips[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(tips);
		
		long sum = 0;
		for (int i = N - 1, j = 1; i >= 0; i--, j++) {
			long tip = tips[i] - j + 1;
			if (tip <= 0) {
				break;
			}
			sum += tip;
		}
		System.out.println(sum);
	}

}
