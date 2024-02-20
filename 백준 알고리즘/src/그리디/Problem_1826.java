package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1826 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Station[] stations = new Station[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			stations[i] = new Station(a, b);
		}
		Arrays.sort(stations);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		int answer = 0, index = 0;
		while (P < L) {
			while (index < N && stations[index].a <= P) {
				q.add(stations[index++].b);
			}
			if (q.isEmpty()) {
				System.out.println(-1);
				return;
			}
			P += q.poll();
			answer++;
		}
		System.out.println(answer);
	}
	
	private static final class Station implements Comparable<Station> {
		int a, b;
		
		public Station(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int compareTo(Station o) {
			return Integer.compare(a, o.a);
		}
	}

}
