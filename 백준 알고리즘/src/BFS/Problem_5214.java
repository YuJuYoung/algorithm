package BFS;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_5214 {
	
	private static int[][] tube;
	private static Node[] group;
	private static boolean[] vstTube;
	private static boolean[] visited;

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int N = in.readInt();
		int K = in.readInt();
		int M = in.readInt();
		tube = new int[M][K];
		group = new Node[N + 1];
		vstTube = new boolean[M];
		visited = new boolean[N + 1];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < K; j++) {
				int n = in.readInt();
				
				tube[i][j] = n;
				group[n] = new Node(i, group[n]);
			}
		}
		System.out.println(bfs(N, K));
	}
	
	private static int bfs(int N, int K) {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		
		int count = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				int n = q.poll();
				
				if (n == N) {
					return count;
				}
				for (Node next = group[n]; next != null; next = next.next) {
					if (vstTube[next.n]) {
						continue;
					}
					
					for (int st : tube[next.n]) {
						if (!visited[st]) {
							q.add(st);
							visited[st] = true;
						}
					}
					vstTube[next.n] = true;
				}
			}
			count++;
		}
		return -1;
	}
	
	private static class Node {
		int n;
		Node next;
		
		public Node(int n, Node next) {
			this.n = n;
			this.next = next;
		}
	}
	
	private static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1) {
				throw new InputMismatchException();
			}
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}

		public int readInt() {
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
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public boolean isSpaceChar(int c) {
			if (filter != null) {
				return filter.isSpaceChar(c);
			}
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
}
