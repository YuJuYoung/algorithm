package ±×¸®µð;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_11000 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Class[] classes = new Class[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			classes[i] = new Class(start, end);
		}
		Arrays.sort(classes);
		
		Queue<Integer> q = new PriorityQueue<>();
		q.add(classes[0].end);
		for (int i = 1; i < N; i++) {
			if (q.peek() <= classes[i].start) {
				q.poll();
			}
			q.add(classes[i].end);
		}
		System.out.println(q.size());
	}
	
	private static final class Class implements Comparable<Class> {
		int start, end;
		
		public Class(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Class o) {
			return Integer.compare(start, o.start);
		}
	}

}
