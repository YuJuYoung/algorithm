package ±×¸®µð;

import java.io.*;
import java.util.*;

public class Problem_10165 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		Queue<Bus> A = new PriorityQueue<>((x, y) -> {
			if (x.s == y.s) {
				if (x.e == y.e) {
					return Integer.compare(y.d, x.d);
				}
				return Integer.compare(y.e, x.e);
			}
			return Integer.compare(x.s, y.s);
		});
		Queue<Bus> B = new PriorityQueue<>((x, y) -> {
			if (x.e == y.e) {
				return Integer.compare(x.s, y.s);
			}
			return Integer.compare(y.e, x.e);
		});
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = i + 1;
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			if (s > e) {
				B.add(new Bus(n, s, e, 1));
			} else {
				A.add(new Bus(n, s, e, 0));
			}
		}
		
		List<Integer> answer = new ArrayList<>();
		while (!B.isEmpty()) {
			Bus bus = B.poll();
			int n = bus.n;
			int s = bus.s;
			int e = bus.e;
			int d = bus.d;
			
			while (!B.isEmpty() && B.peek().s >= s) {
				B.poll();
			}
			if (e > 0) {
				A.add(new Bus(0, 0, e, d));
			}
			A.add(new Bus(0, s, N, d));
			answer.add(n);
		}
		while (!A.isEmpty()) {
			Bus bus = A.poll();
			int n = bus.n;
			int e = bus.e;
			
			while (!A.isEmpty() && A.peek().e <= e) {
				A.poll();
			}
			if (n != 0) {
				answer.add(n);
			}
		}
		
		Collections.sort(answer);
		for (int n : answer) {
			bw.write(n + " ");
		}
		bw.close();
	}
	
	private static final class Bus {
		int n, s, e, d;
		
		public Bus(int n, int s, int e, int d) {
			this.n = n;
			this.e = e;
			this.s = s;
			this.d = d;
		}
	}

}
