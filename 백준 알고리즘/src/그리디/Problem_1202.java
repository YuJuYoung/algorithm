package 그리디;

import java.io.*;
import java.util.*;

public class Problem_1202 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] jewelrys = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewelrys[i][0] = Integer.parseInt(st.nextToken());
			jewelrys[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(jewelrys, (x, y) -> Integer.compare(x[0], y[0]));
		
		int[] bags = new int[K];
		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags);
		
		Queue<Integer> q = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
		int sum = 0;
		int index = 0;
		for (int i = 0; i < K; i++) {
			while (index < N && jewelrys[index][0] <= bags[i]) {
				q.add(jewelrys[index++][1]);
			}
			if (!q.isEmpty()) {
				sum += q.poll();
			}
		}
		bw.write(sum + "\n");
		bw.close();
	}

}