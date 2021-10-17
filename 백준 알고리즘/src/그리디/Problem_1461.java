package ±×¸®µð;

import java.io.*;
import java.util.*;

public class Problem_1461 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Queue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
		Queue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (num < 0) {
				minus.add(-num);
			} else {
				plus.add(num);
			}
		}
		
		int answer = 0;
		
		if (plus.isEmpty()) {
			answer = remove(minus, M);
		} else if (minus.isEmpty()) {
			answer = remove(plus, M);
		} else {
			if (plus.peek() > minus.peek()) {
				answer = remove(plus, M);
			} else {
				answer = remove(minus, M);
			}
		}
		System.out.println(answer + cal(plus, M) + cal(minus, M));
	}
	
	private static int remove(Queue<Integer> q, int M) {
		int num = q.poll();
		for (int i = 1; i < M; i++) {
			q.poll();
		}
		return num;
	}
	
	private static int cal(Queue<Integer> q, int M) {
		int sum = 0;
		while (!q.isEmpty()) {
			sum += q.poll() * 2;
			
			for (int i = 1; i < M; i++) {
				if (q.isEmpty()) {
					break;
				}
				q.poll();
			}
		}
		return sum;
	}

}
