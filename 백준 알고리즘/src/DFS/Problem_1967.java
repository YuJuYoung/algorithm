package DFS;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Problem_1967 {
	
	private static Node[] tree;
	private static int ans = 0;

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		tree = new Node[n + 1];
		
		for (int i = 1; i < n; i++) {
			int u = in.nextInt();
			int v = in.nextInt();
			int d = in.nextInt();
			tree[u] = new Node(v, d, tree[u]);
		}
		
		dfs(1, 0);
		System.out.println(ans);
	}
	
	private static int dfs(int n, int d) {
		int max = 0;
		int a = 0, b = 0;
		
		for (Node next = tree[n]; next != null; next = next.next) {
			int nd = dfs(next.n, next.d);
			if (max < nd) {
				max = nd;
			}
			
			if (nd > a) {
				b = a;
				a = nd;
				continue;
			}
			if (nd > b) {
				b = nd;
			}
		}
		int sum = a + b;
		
		if (ans < sum) {
			ans = sum;
		}
		return d + max;
	}
	
	private static class Node {
		int n, d;
		Node next;
		
		public Node(int n, int d, Node next) {
			this.n = n;
			this.d = d;
			this.next = next;
		}
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
