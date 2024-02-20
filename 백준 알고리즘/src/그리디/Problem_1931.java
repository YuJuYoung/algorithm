package 그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1931 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<int[]> q = new PriorityQueue<>((x, y) -> {
			if (x[1] == y[1]) {
				return Integer.compare(x[0], y[0]);
			}
			return Integer.compare(x[1], y[1]);
		});
		
		for (int N = Integer.parseInt(br.readLine()); N > 0; N--) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			q.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}
		int last = q.poll()[1], count = 1;;
		while (!q.isEmpty()) {
			int[] conference = q.poll();
			if (conference[0] >= last) {
				last = conference[1];
				count++;
			}
		}
		bw.write(count + "\n");
		bw.close();
	}

}
