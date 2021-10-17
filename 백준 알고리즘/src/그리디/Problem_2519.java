package ±×¸®µð;

import java.io.*;
import java.util.*;

public class Problem_2519 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		Queue<Apart> minus = new PriorityQueue<>();
		Queue<Apart> plus = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int d = S - Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if (d < 0) {
				minus.add(new Apart(-d, n));
			} else {
				plus.add(new Apart(d, n));
			}
		}
		System.out.println(cal(minus, K) + cal(plus, K));
	}
	
	private static int cal(Queue<Apart> q, int K) {
		int sum = 0;
		while (!q.isEmpty()) {
			int d = q.peek().d;
			int count = 0;
			
			while (!q.isEmpty() && count < K) {
				Apart temp = q.poll();
				count += temp.n;
				
				if (count > K) {
					temp.n = count - K;
					q.add(temp);
				}
			}
			sum += d * 2;
		}
		return sum;
	}
	
	private static class Apart implements Comparable<Apart> {
		int d, n;
		
		public Apart(int d, int n) {
			this.d = d;
			this.n = n;
		}
		
		@Override
		public int compareTo(Apart o) {
			return Integer.compare(o.d, d);
		}
	}

}
