package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_8980 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		Box[] boxes = new Box[M];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			boxes[i] = new Box(s, e, c);
		}
		Arrays.sort(boxes, (x, y) -> Integer.compare(x.e, y.e));
		
		int[] counts = new int[N + 1];
		Arrays.fill(counts, C);
		
		int answer = 0;
		for (int i = 0; i < M; i++) {
			int s = boxes[i].s;
			int e = boxes[i].e;
			int c = boxes[i].c;
			
			int min = counts[s];
			for (int j = s + 1; j < e; j++) {
				min = Math.min(counts[j], min);
			}
			if (min < c) {
				c = min;
			}
			for (int j = s; j < e; j++) {
				counts[j] -= c;
			}
			answer += c;
		}
		System.out.println(answer);
	}
	
	private static class Box {
		int s, e, c;
		
		public Box(int s, int e, int c) {
			this.s = s;
			this.e = e;
			this.c = c;
		}
	}

}
