package 그리디;

import java.io.*;
import java.util.*;

public class Problem_1781 {

	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader(System.in);
		
		int N = in.readInt();
		Homework[] homeworks = new Homework[N];
		
		for (int i = 0; i < N; i++) {
			homeworks[i] = new Homework(in.readInt(), in.readInt());
		}
		Arrays.sort(homeworks);
		
		Queue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			q.add(homeworks[i].count);
			if (q.size() > homeworks[i].time) {
				q.poll();
			}
		}
		
		int sum = 0;
		while (!q.isEmpty()) {
			sum += q.poll();
		}
		System.out.println(sum);
	}
	
	private static final class Homework implements Comparable<Homework> {
		int time, count;
		
		public Homework(int time, int count) {
			this.time = time;
			this.count = count;
		}
		
		@Override
		public int compareTo(Homework o) {
			return Integer.compare(time, o.time);
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
