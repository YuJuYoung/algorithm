package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem_10826 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		if (n == 0 || n == 1) {
			System.out.println(n);
			return;
		}
		
		BigInteger left = new BigInteger("0"), right = new BigInteger("1");
		while (n-- > 1) {
			BigInteger temp = right;
			right = left.add(right);
			left = temp;
		}
		System.out.println(right);
	}

}
