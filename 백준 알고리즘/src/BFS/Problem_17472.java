package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_17472 {
	
	private static int N, M;
	private static int[][] map;
	
	private static Queue<int[]> q = new LinkedList<>();
	private static int[] dx = { 0, 1, -1, 0 };
	private static int[] dy = { 1, 0, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? -1 : -2;
			}
		}
		
		int color = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1) {
					dfs(j, i, color++);
				}
			}
		}
		System.out.println(bfs(color));
	}
	
	private static int bfs(int max) {
		Union_find uf = new Union_find(max);
		int sum = 0, count = 1;
		
		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int x = arr[0];
			int y = arr[1];
			int d = arr[2];
			int i = arr[3];
			int c = arr[4];
			
			if (i == 0) {
				y++;
			} else {
				x++;
			}
			if (isInside(x, y)) {
				if (map[y][x] != -2) {
					if (d < 2 || map[y][x] == c) {
						continue;
					}
					
					if (uf.union(c, map[y][x])) {
						sum += d;
						
						if (++count == max) {
							return sum;
						}
					}
				} else {
					q.add(new int[] { x, y, d + 1, i, c });
				}
			}
		}
		return -1;
	}
	
	private static void dfs(int x, int y, int color) {
		q.add(new int[] { x, y, 0, 0, color });
		q.add(new int[] { x, y, 0, 1, color });
		map[y][x] = color;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (isInside(nx, ny) && map[ny][nx] == -1) {
				dfs(nx, ny, color);
			}
		}
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < M && y >= 0 && y < N;
	}
	
	private static class Union_find {
		int[] arr;
		
		public Union_find(int n) {
			arr = new int[n];
			
			for (int i = 1; i < n; i++) {
				arr[i] = i;
			}
		}
		
		public int find(int n) {
			if (arr[n] == n) {
				return n;
			}
			return arr[n] = find(arr[n]);
		}
		
		public boolean union(int a, int b) {
			a = find(a);
			b = find(b);
			
			if (a == b) {
				return false;
			}
			arr[b] = a;
			return true;
		}
	}
	
}
