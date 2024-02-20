package 그리디;

import java.io.*;
import java.util.*;

public class Problem_9576 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			boolean[] books = new boolean[N + 1];
			
			Application[] applications = new Application[M];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				applications[i] = new Application(a, b);
			}
			Arrays.sort(applications);
			int answer = 0;
			for (int i = 0; i < M; i++) {
				for (int j = applications[i].a; j <= applications[i].b; j++) {
					if (!books[j]) {
						books[j] = true;
						answer++;
						break;
					}
				}
			}
			bw.write(answer + "\n");
		}
		bw.close();
	}
	
	private static final class Application implements Comparable<Application> {
		int a, b;
		
		public Application(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int compareTo(Application o) {
			if (b == o.b) {
				return a - o.a;
			}
			return b - o.b;
		}
	}

}