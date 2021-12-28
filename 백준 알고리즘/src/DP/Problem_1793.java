package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Problem_1793 {
	
	private static BigInteger[] cache;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		cache = new BigInteger[251];
		cache[0] = cache[1] = BigInteger.ONE;
		cache[2] = new BigInteger("3");
		
		String input = null;
		
		while ((input = br.readLine()) != null) {
			bw.write(dfs(Integer.parseInt(input)) + "\n");
		}
		bw.close();
	}
	
	private static BigInteger dfs(int n) {
		if (cache[n] != null) {
			return cache[n];
		}
		return cache[n] = dfs(n - 1).add(dfs(n - 2).multiply(BigInteger.TWO));
	}

}
