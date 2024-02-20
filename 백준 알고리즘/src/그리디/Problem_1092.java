package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1092 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] crains = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			crains[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(crains);
		
		int M = Integer.parseInt(br.readLine());
		int[] boxes = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			boxes[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(boxes);
		
		if (crains[N - 1] < boxes[M - 1]) {
			System.out.println(-1);
			return;
		}
		
		int[] counts = new int[N];
		int crain = 0;
		for (int i = 0; i < M; i++) {
			int box = boxes[i];
			while (crains[crain] < box) {
				crain++;
			}
			counts[crain]++;
		}
		int answer = 0;
		for (int i = N - 1, j = 1; i >= 0; i--, j++) {
			counts[i] -= answer;
			if (counts[i] < 0 && i > 0) {
				counts[i - 1] += counts[i];
			}
			if (counts[i] > 0) {
				answer += counts[i] / j;
			}
		}
		System.out.println(answer);
	}

}