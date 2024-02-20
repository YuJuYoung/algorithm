package 구현;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class Problem_2167 {

	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = in.nextInt();
		int M = in.nextInt();
		int[][] dp = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j] += dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + in.nextInt();;
			}
		}
		
		for (int K = in.nextInt(); K > 0; K--) {
			int i = in.nextInt() - 1;
			int j = in.nextInt() - 1;
			int x = in.nextInt();
			int y = in.nextInt();
			
			bw.write((dp[x][y] - dp[x][j] - dp[i][y] + dp[i][j]) + "\n");
		}
		bw.close();
	}
	
	private static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1) {
				throw new InputMismatchException();
			} else {
				if (curChar >= numChars) {
					curChar = 0;
					try {
						numChars = stream.read(buf);
					} catch (IOException var2) {
						throw new InputMismatchException();
					}
					if (numChars <= 0) {
						return -1;
					}
				}
				return buf[curChar++];
			}
		}

		public boolean isSpace(int c) {
			return c == 10 || c == 13 || c == -1 || c == 9 || c == 32;
		}

		public int nextInt() {
			int c = this.read();
			while (isSpace(c)) {
				c = this.read();
			}
			byte sgn = 1;
			if (c == 45) {
				sgn = -1;
				c = this.read();
			}
			int res = 0;
			while (c >= 48 && c <= 57) {
				res *= 10;
				res += c - 48;
				c = this.read();
				if (isSpace(c)) {
					return res * sgn;
				}
			}
			throw new InputMismatchException();
		}

	}

}
