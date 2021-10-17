package ±×¸®µð;

import java.io.*;
import java.util.*;

public class Problem_12018 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Queue<Integer> mins = new PriorityQueue<>();
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			if (p < l) {
				br.readLine();
				mins.add(1);
				continue;
			}
			
			Queue<Integer> q = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			
			while (p-- > 0) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			while (q.size() > l) {
				q.poll();
			}
			mins.add(q.poll());
		}
		
		int answer = 0;
		while (!mins.isEmpty()) {
			m -= mins.poll();
			if (m < 0) {
				break;
			}
			answer++;
		}
		System.out.println(answer);
	}

}
