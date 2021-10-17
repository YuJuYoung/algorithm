package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1194 {
	
	private static int N, M;
	private static char[][] map;
	private static boolean[][][] visited;
	
	private static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][1 << 6];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				
				if (map[i][j] == '0') {
					q.add(new Point(j, i, 0));
					
					visited[i][j][0] = true;
					map[i][j] = '.';
				}
			}
		}
		System.out.println(bfs());
	}
	
	private static int bfs() {
		int[] dx = { 0, -1, 1, 0 };
		int[] dy = { 1, 0, 0, -1 };
		
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				Point p = q.poll();
				int x = p.x;
				int y = p.y;
				if (map[y][x] == '1') {
					return time;
				}
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					int key = p.key;
					
					if (isInside(nx, ny) && map[ny][nx] != '#') {
						if (map[ny][nx] >= 'a' && map[ny][nx] <= 'f') {
							key = key | (1 << (map[ny][nx] - 97));
						}
						if (map[ny][nx] >= 'A' && map[ny][nx] <= 'F') {
							int tmp = 1 << (map[ny][nx] - 65);
							
							if ((key & tmp) == 0) {
								continue;
							}
						}
						
						if (!visited[ny][nx][key]) {
							q.add(new Point(nx, ny, key));
							visited[ny][nx][key] = true;
						}
					}
				}
			}
			time++;
		}
		return -1;
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < M && y >= 0 && y < N;
	}
	
	private static class Point {
		int x, y, key;
		
		public Point(int x, int y, int key) {
			this.x = x;
			this.y = y;
			this.key = key;
		}
	}

}
