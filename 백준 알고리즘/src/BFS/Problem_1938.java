package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_1938 {
	
	private static int N, fx = 0, fy = 0, fd = 0;
	private static char[][] map;
	private static boolean[][][] visited;
	
	private static Queue<Log> q = new LinkedList<>();
	private static int[] dx = { 0, 1, -1, 0 };
	private static int[] dy = { 1, 0, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N][2];
		
		int countB = 0, countE = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				
				if (map[i][j] == 'B' && ++countB == 2) {
					add(j, i, j > 0 && map[i][j - 1] == 'B' ? 0 : 1);
				}
				if (map[i][j] == 'E' && ++countE == 2) {
					fx = j;
					fy = i;
					fd = j > 0 && map[i][j - 1] == 'E' ? 0 : 1;
				}
			}
		}
		System.out.println(bfs());
	}
	
	private static int bfs() {
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				Log tmp = q.poll();
				int x = tmp.x;
				int y = tmp.y;
				int d = tmp.d;
				if (x == fx && y == fy && d == fd) {
					return time;
				}
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (!isBlocked(nx, ny, d) && !visited[ny][nx][d]) {
						add(nx, ny, d);
					}
				}
				d = (d + 1) % 2;
				
				if (!isBlocked(x, y, d)) {
					if (map[y - 1][x - 1] != '1' && map[y + 1][x + 1] != '1' &&
							map[y - 1][x + 1] != '1' && map[y + 1][x - 1] != '1' && !visited[y][x][d]) {
						add(x, y, d);
					}
				}
			}
			time++;
		}
		return 0;
	}
	
	private static void add(int x, int y, int d) {
		q.add(new Log(x, y, d));
		visited[y][x][d] = true;
	}
	
	private static boolean isBlocked(int x, int y, int d) {
		if (d == 0) {
			if (y >= 0 && y < N && x > 0 && x + 1 < N) {
				if (map[y][x - 1] != '1' && map[y][x + 1] != '1' && map[y][x] != '1') {
					return false;
				}
			}
		} else {
			if (x >= 0 && x < N && y > 0 && y + 1 < N) {
				if (map[y - 1][x] != '1' && map[y + 1][x] != '1' && map[y][x] != '1') {
					return false;
				}
			}
		}
		return true;
	}
	
	private static class Log {
		int x, y, d;
		
		public Log(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

}
