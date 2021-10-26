package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_18405 {
	private static Queue<Virus> pq;
	private static int N, K;
	private static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] > 0) {
					pq.add(new Virus(j, i));
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()) - 1;
		int Y = Integer.parseInt(st.nextToken()) - 1;
		
		System.out.println(bfs(S, X, Y));
	}
	
	private static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	
	private static int bfs(int S, int X, int Y) {
		while (!pq.isEmpty() && S-- > 0) {
			Queue<Virus> newPQ = new PriorityQueue<>();
			
			while (!pq.isEmpty()) {
				Virus v = pq.poll();
				int x = v.x;
				int y = v.y;
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (isInside(nx, ny) && map[ny][nx] == 0) {
						map[ny][nx] = map[y][x];
						newPQ.add(new Virus(nx, ny));
					}
				}
			}
			pq = newPQ;
		}
		return map[X][Y];
	}
	
	private static boolean isInside(int x, int y) {
		return !(x == -1 || x == N || y == -1 || y == N);
	}
	
	private static class Virus implements Comparable<Virus> {
		int x, y;
		
		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Virus o) {
			return Integer.compare(map[y][x], map[o.y][o.x]);
		}
	}
}
