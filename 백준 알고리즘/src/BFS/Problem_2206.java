package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_2206 {
	
	private static int N, M;
	private static char[][] map;
	private static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][2];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				
				if (map[i][j] == '1') {
					visited[i][j][1] = true;
				}
			}
		}
		
		System.out.println(bfs());
	}
	
	private static int bfs() {
		Queue<Current> q = new LinkedList<>();
		q.add(new Current(0, 0, 0));
		visited[0][0][0] = true;
		
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, -1, 0, 1 };
		
		int count = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				Current temp = q.poll();
				
				int x = temp.x;
				int y = temp.y;
				if (x == M - 1 && y == N - 1) {
					return count;
				}
				int breaked = temp.breaked;
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (isInside(nx, ny) && !visited[ny][nx][breaked]) {
						if (map[ny][nx] == '0') {
							q.add(new Current(nx, ny, breaked));
							visited[ny][nx][breaked] = true;
						} else {
							if (breaked == 0) {
								q.add(new Current(nx, ny, 1));
								visited[ny][nx][1] = true;
							}
						}
					}
				}
			}
			count++;
		}
		return -1;
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < M && y >= 0 && y < N;
	}
	
	private static class Current {
		int x, y;
		int breaked;
		
		public Current(int x, int y, int breaked) {
			this.x = x;
			this.y = y;
			this.breaked = breaked;
		}
	}

}
