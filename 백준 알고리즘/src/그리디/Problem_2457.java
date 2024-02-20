package 그리디;

import java.io.*;
import java.util.*;

public class Problem_2457 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Flower[] flowers = new Flower[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
			flowers[i] = new Flower(start, end);
		}
		Arrays.sort(flowers);
		
		int last = 301, max = 0;
		int answer = 0;
		for (int i = 0; i < N; i++) {
			int start = flowers[i].start;
			int end = flowers[i].end;
            if (start == end) {
                continue;
            }
			if (last >= start) {
				max = Math.max(max, end);
			} else {
				if (max == 0) {
					answer = 0;
					break;
				} else {
					last = max;
					max = 0;
					answer++;
					if (last > 1130) {
						break;
					}
					i--;
				}
			}
		}
		System.out.println(max != 0 ? max > 1130 ? answer + 1 : 0 : answer);
	}
	
	private static final class Flower implements Comparable<Flower> {
		int start, end;
		
		public Flower(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Flower o) {
			return Integer.compare(start, o.start);
		}
	}

}