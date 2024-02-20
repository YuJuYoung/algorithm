package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1475 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] count = new int[10];
		for (char c : br.readLine().toCharArray()) {
			count[c - 48]++;
		}
		count[6] = (count[6] + count[9] + 1) / 2;
		
		int max = count[0];
		for (int i = 1; i <= 8; i++) {
			if (max < count[i]) {
				max = count[i];
			}
		}
		System.out.println(max);
	}

}
