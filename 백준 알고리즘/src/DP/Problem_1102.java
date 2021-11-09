package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem_1102 {
	
	private static int N;
	private static int[][] costs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		costs = new int[N][N];
		
		for (int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				costs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		String str = br.readLine();
		int startBit = 0, turnedOnCnt = 0;
		
		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == 'Y') {
				startBit += 1 << i;
				turnedOnCnt++;
			}
		}
		
		int P = Integer.parseInt(br.readLine());
		int startTime = P - turnedOnCnt;
		
		if (startTime <= 0) {
			System.out.println(0);
		} else {
			System.out.println(findMin(startBit, startTime));
		}
	}
	
	private static int findMin(int startBit, int time) {
		Queue<QueueNode> pq = new PriorityQueue<>();
		Set<Integer> visited = new HashSet<>();
		
		pq.add(new QueueNode(startBit, 0, time));
		
		while (!pq.isEmpty()) {
			QueueNode node = pq.poll();
			
			if (node.time == 0) {
				return node.cost;
			}
			if (visited.contains(node.bit)) {
				continue;
			}
			visited.add(node.bit);
			
			for (int j = 0; j < N; j++) {
				int nextBit = node.bit | (1 << j);
				
				if (nextBit == node.bit) {
					continue;
				}
				
				int minCost = Integer.MAX_VALUE;
				
				for (int i = 0; i < N; i++) {
					if ((node.bit | (1 << i)) == node.bit) {
						minCost = Math.min(minCost, costs[i][j]);
					}
				}
				
				if (minCost != Integer.MAX_VALUE) {
					pq.add(new QueueNode(nextBit, node.cost + minCost, node.time - 1));
				}
			}
		}
		return -1;
	}
	
	private static class QueueNode implements Comparable<QueueNode> {
		int bit, cost, time;
		
		public QueueNode(int bit, int cost, int time) {
			this.bit = bit;
			this.cost = cost;
			this.time = time;
		}

		@Override
		public int compareTo(QueueNode o) {
			return Integer.compare(cost, o.cost);
		}
	}

}
