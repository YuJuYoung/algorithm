package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1981 {
	
	private static int n, min = 200, max = 0;
	private static int[][] map;
	private static Pair[][] pair;
	
	private static int[] dx = { 1, 0, -1, 0 };
	private static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		pair = new Pair[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
				pair[i][j] = new Pair(j, i);
			}
		}
		System.out.println(binarySearch());
	}
	
	private static int binarySearch() {
		int l = 0, r = max - min;
		int ans = 200;
		
		while (l <= r) {
			int mid = (l + r) / 2;
			
			if (bfs(mid)) {
				ans = Math.min(ans, mid);
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return ans;
	}
	
	private static boolean bfs(int gap) {
		for (int low = min; low + gap <= max; low++) {
			if (map[0][0] < low || map[0][0] > low + gap) {
				continue;
			}
			boolean[][] visited = new boolean[n][n];
			
			Queue<Pair> q = new LinkedList<>();
			q.add(pair[0][0]);
			visited[0][0] = true;
			
			while (!q.isEmpty()) {
				Pair p = q.poll();
				int x = p.x;
				int y = p.y;
				if (x == n - 1 && y == n - 1) {
					return true;
				}
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (isInside(nx, ny) && !visited[ny][nx]) {
						if (map[ny][nx] < low || map[ny][nx] > low + gap) {
							continue;
						}
						q.add(pair[ny][nx]);
						visited[ny][nx] = true;
					}
				}
			}
		}
		return false;
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
	
	private static class Pair {
		int x, y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
