package DP;

import java.io.*;
import java.util.*;

public class Problem_1912 {

	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int[] dp = new int[n];
		
		int max = dp[0] = in.nextInt();
		for (int i = 1; i < n; i++) {
			dp[i] = in.nextInt();
			
			if (dp[i - 1] > 0) {
				dp[i] += dp[i - 1];
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
	
	private static class InputReader {
		private final InputStream stream;
		private final byte[] buf = new byte[8192];
		private int curChar, snumChars;

		public InputReader(InputStream st) {
			this.stream = st;
		}

		public int read() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int nextInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	}

}
