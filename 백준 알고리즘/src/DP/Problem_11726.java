package DP;

import java.io.*;

public class Problem_11726 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		if (n == 1 || n == 2) {
			System.out.println(n);
		} else {
			int count = n - 2;
			int left = 1, right = 2;
			
			while (count-- > 0) {
				int temp = right;
				right = (left + right) % 10007;
				left = temp;
			}
			System.out.println(right);
		}
	}

}
