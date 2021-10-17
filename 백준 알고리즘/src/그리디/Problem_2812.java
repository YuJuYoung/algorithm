package ±×¸®µð;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2812 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String number = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (K == 0) {
				sb.append(number.substring(i));
				break;
			}
			char left = number.charAt(i);
			if (left == '9') {
				sb.append(left);
				continue;
			}
			boolean isReduced = false;
			for (int j = i + 1; j < N && j < i + K + 1; j++) {
				char right = number.charAt(j);
				
				if (left < right) {
					K -= j - i;
					i = j - 1;
					isReduced = true;
					break;
				}
			}
			if (!isReduced) {
				sb.append(left);
			}
		}
		System.out.println(sb.delete(sb.length() - K, sb.length()));
	}

}
