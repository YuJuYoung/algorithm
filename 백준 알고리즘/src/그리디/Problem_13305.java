package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_13305 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] roads = new long[N - 1];
		int[] stations = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			roads[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			stations[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = 1000000000;
		long answer = 0;
		for (int i = 0; i < N - 1; i++) {
			min = Math.min(min, stations[i]);
			answer += min * roads[i];
		}
		System.out.println(answer);
	}

}
