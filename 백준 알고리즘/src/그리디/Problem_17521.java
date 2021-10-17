package ±×¸®µð;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_17521 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		long W = Integer.parseInt(st.nextToken());
		long count = 0;
		int byteCoin = 0;
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (count == 0) {
				byteCoin = num;
				count = W / byteCoin;
				W %= byteCoin;
			} else {
				if (num > byteCoin) {
					byteCoin = num;
				} else {
					W += count * byteCoin;
					byteCoin = num;
					count = W / byteCoin;
					W %= byteCoin;
				}
			}
		}
		System.out.println(W + count * byteCoin);
	}

}
