package 그리디;

import java.io.*;
import java.util.*;

public class Problem_2109 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		College[] colleges = new College[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			colleges[i] = new College(p, d);
		}
		Arrays.sort(colleges);
		
		Queue<Integer> q = new PriorityQueue<>();
		int answer = 0;
		for (int i = 0; i < n; i++) {
			int p = colleges[i].p;
			int d = colleges[i].d;
			
			if (q.size() <= d) {
				q.add(p);
				answer += p;
			}
			if (q.size() > d) {
				answer -= q.poll();
			}
		}
		System.out.println(answer);
	}
	
	private static final class College implements Comparable<College> {
		int p, d;
		
		public College(int p, int d) {
			this.p = p;
			this.d = d;
		}
		
		@Override
		public int compareTo(College o) {
			return Integer.compare(d, o.d);
		}
	}

}
