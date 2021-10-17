package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_16953 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		q.add(B);
		
		int time = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				int n = q.poll();
				if (n == A) {
					System.out.println(time);
					return;
				}
				
				if (n % 2 == 0 && n / 2 >= A) {
					q.add(n / 2);
				}
				if (n % 10 == 1 && n / 10 >= A) {
					q.add(n / 10);
				}
			}
			time++;
		}
		System.out.println(-1);
	}

}
