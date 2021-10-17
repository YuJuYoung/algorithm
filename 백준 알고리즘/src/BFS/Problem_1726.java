package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1726 {
	
	private static int N, M;
	private static char[][] map;
	private static boolean[][][] visited;
	
	private static Queue q;
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };
	private static int[][] cache = { { 0, 2, 1, 1 }, { 2, 0, 1, 1 }, { 1, 1, 0, 2 }, { 1, 1, 2, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][4];
		q = new Queue(N, M);
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j * 2);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		int y = Integer.parseInt(st.nextToken()) - 1;
		int x = Integer.parseInt(st.nextToken()) - 1;
		int d = Integer.parseInt(st.nextToken()) - 1;
		
		q.add(new Robot(x, y, d, 0));
		visited[y][x][d] = true;
		
		st = new StringTokenizer(br.readLine());
		
		int fy = Integer.parseInt(st.nextToken()) - 1;
		int fx = Integer.parseInt(st.nextToken()) - 1;
		int fd = Integer.parseInt(st.nextToken()) - 1;
		System.out.println(bfs(fx, fy, fd));
	}
	
	private static int bfs(int fx, int fy, int fd) {
		while (!q.isEmpty()) {
			Robot tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			int d = tmp.d;
			int t = tmp.t;
			if (x == fx && y == fy && d == fd) {
				return t;
			}
			int nt = t + 1;
			
			for (int i = 0; i < 4; i++) {
				if (cache[d][i] == 2) {
					continue;
				}
				if (cache[d][i] == 1) {
					if (!visited[y][x][i]) {
						q.add(new Robot(x, y, i, nt));
						visited[y][x][i] = true;
					}
				} else {
					int nx = x;
					int ny = y;
					int count = 0;
					
					while (count++ < 3) {
						nx += dx[i];
						ny += dy[i];
						
						if (!isInside(nx, ny) || map[ny][nx] == '1') {
							break;
						}
						if (!visited[ny][nx][i]) {
							q.add(new Robot(nx, ny, i, nt));
							visited[ny][nx][i] = true;
						}
					}
				}
			}
		}
		return -1;
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < M && y >= 0 && y < N;
	}
	
	private static class Robot {
		int x, y, d, t;
		
		public Robot(int x, int y, int d, int t) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.t = t;
		}
	}
	
	private static class Queue {
		Robot[] q;
		int r = -1, f = -1;
		
		public Queue(int N, int M) {
			q = new Robot[N * M * 4];
		}
		
		public boolean isEmpty() {
			return f == r;
		}
		
		public void add(Robot r) {
			q[++f] = r;
		}
		
		public Robot poll() {
			return q[++r];
		}
	}

}
