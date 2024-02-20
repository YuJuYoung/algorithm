package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_2212 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[] sensors = new int[N];
		
		if (N < K) {
			System.out.println(0);
			return;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sensors[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sensors);
		
		Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 1; i < N; i++) {
			q.add(sensors[i] - sensors[i - 1]);
		}
		
		int answer = sensors[N - 1] - sensors[0];
		for (int i = 1; i < K; i++) {
			answer -= q.poll();
		}
		System.out.print(answer);
	}

}
