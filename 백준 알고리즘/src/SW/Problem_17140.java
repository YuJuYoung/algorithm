package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_17140 {
	
	private static Queue<Node> pq = new PriorityQueue<>();
	private static int[][] A = new int[100][100];
	private static int r, c, k, maxR = 3, maxC = 3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		k = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 3; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		while (time <= 100) {
			if (A[r][c] == k) {
				System.out.println(time);
				return;
			}
			if (maxR >= maxC) {
				sortR();
			} else {
				sortC();
			}
			time++;
		}
		System.out.println(-1);
	}
	
	private static void sortR() {
		for (int i = 0; i < maxR; i++) {
			int[] count = new int[101];
			int max = 0;
			for (int j = 0; j < maxC; j++) {
				if (A[i][j] > 0) {
					count[A[i][j]]++;
					max = Math.max(max, A[i][j]);
				}
			}
			
			for (int j = 1; j <= 100; j++) {
				if (count[j] > 0) {
					pq.add(new Node(j, count[j]));
				}
			}
			
			int index = 0;
			while (!pq.isEmpty()) {
				Node node = pq.poll();
				A[i][index++] = node.value;
				A[i][index++] = node.count;
			}
			while (index < maxC) {
				A[i][index++] = 0;
			}
			maxC = Math.max(maxC, index);
		}
	}
	
	private static void sortC() {
		for (int j = 0; j < maxC; j++) {
			int[] count = new int[101];
			int max = 0;
			for (int i = 0; i < maxR; i++) {
				if (A[i][j] > 0) {
					count[A[i][j]]++;
					max = Math.max(max, A[i][j]);
				}
			}
			
			for (int i = 1; i <= max; i++) {
				if (count[i] > 0) {
					pq.add(new Node(i, count[i]));
				}
			}
			
			int index = 0;
			while (!pq.isEmpty()) {
				Node node = pq.poll();
				A[index++][j] = node.value;
				A[index++][j] = node.count;
			}
			while (index < maxR) {
				A[index++][j] = 0;
			}
			maxR = Math.max(maxR, index);
		}
	}
	
	private static class Node implements Comparable<Node> {
		int value, count;
		
		public Node(int value, int count) {
			this.value = value;
			this.count = count;
		}

		@Override
		public int compareTo(Node o) {
			if (count == o.count) {
				return Integer.compare(value, o.value);
			}
			return Integer.compare(count, o.count);
		}
	}

}
