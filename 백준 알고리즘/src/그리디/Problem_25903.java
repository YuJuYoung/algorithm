package ±×¸®µð;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_25903 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Queue<Long> q = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			q.add(Long.parseLong(st.nextToken()));
		}
		for (int i = 0; i < m; i++) {
			long sum = q.poll() + q.poll();
			q.add(sum);
			q.add(sum);
		}
		long answer = 0;
		while (!q.isEmpty()) {
			answer += q.poll();
		}
		System.out.println(answer);
	}

}
