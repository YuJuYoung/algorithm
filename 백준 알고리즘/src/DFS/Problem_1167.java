package DFS;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Problem_1167 {
	
	private static int ans = 0;
	private static Node[] tree;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader(System.in);
		
		int V = in.nextInt();
		tree = new Node[V + 1];
		visited = new boolean[V + 1];
		
		for (int i = 1; i <= V; i++) {
			int u = in.nextInt();
			
			while (true) {
				int v = in.nextInt();
				if (v == -1) {
					break;
				}
				
				tree[u] = new Node(v, in.nextInt(), tree[u]);
			}
		}
		
		dfs(1);
		System.out.println(ans);
	}
	
	private static int dfs(int n) {
		visited[n] = true;
		
		int a = 0, b = 0;
		for (Node next = tree[n]; next != null; next = next.next) {
			if (!visited[next.n]) {
				int tmp = dfs(next.n) + next.d;
				
				if (tmp > a) {
					b = a;
					a = tmp;
					continue;
				}
				if (tmp > b) {
					b = tmp;
				}
			}
		}
		
		int sum = a + b;
		if (ans < sum) {
			ans = sum;
		}
		return a;
	}
	
	private static class Node {
		int n, d;
		Node next;
		
		public Node(int n, int d, Node node) {
			this.n = n;
			this.d = d;
			next = node;
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