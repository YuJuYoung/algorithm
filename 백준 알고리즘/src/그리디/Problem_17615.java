package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_17615 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int red = str.replace("B", "").length();
		int blue = N - red;
		
		if (red == 0 || blue == 0) {
			System.out.println(0);
			return;
		}
		
		char c = 'R';
		int min = Integer.MAX_VALUE;
		
		if (str.charAt(0) == 'R') {
			min = blue;
		} else {
			c = 'B';
			min = red;
		}
		
		int count = 1;
		for (int i = 1; i < N; i++) {
			if (str.charAt(i) != c) {
				min = Math.min(min, c == 'R' ? red - count : blue - count);
				break;
			}
			count++;
		}
		count = 1;
		
		if (str.charAt(N - 1) == 'R') {
			c = 'R';
			min = Math.min(blue, min);
		} else {
			c = 'B';
			min = Math.min(red, min);
		}
		
		for (int i = N - 2; i >= 0; i--) {
			if (str.charAt(i) != c) {
				min = Math.min(min, c == 'R' ? red - count : blue - count);
				break;
			}
			count++;
		}
		System.out.println(min);
	}

}
