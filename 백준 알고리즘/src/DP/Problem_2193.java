package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2193 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if (N == 1 || N == 2) {
			System.out.println(1);
			return;
		}
		long left = 1, right = 1;
		int count = N - 2;
		
		while (count-- > 0) {
			long temp = right;
			right = left + right;
			left = temp;
		}
		System.out.println(right);
	}

}
