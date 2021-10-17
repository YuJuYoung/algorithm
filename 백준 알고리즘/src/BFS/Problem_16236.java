package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_16236 {
	
	private static Shark shark = null;
	private static int N;
	private static int[][] map;
	private static int[] dx = { 0, -1, 1, 0 }, dy = { -1, 0, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 9) {
					shark = new Shark(j, i);
					map[i][j] = 0;
				}
			}
		}
		
		int answer = 0;
		while (true) {
			int time = bfs();
			
			if (time == 0) {
				break;
			}
			answer += time;
		}
		System.out.println(answer);
	}
	
	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { shark.x, shark.y });
		
		boolean[][] visited = new boolean[N][N];
		visited[shark.y][shark.x] = true;
		
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				int[] arr = q.poll();
				int x = arr[0];
				int y = arr[1];
				
				if (isSmall(x, y)) {
					while (size-- > 0) {
						arr = q.poll();
						
						if (isSmall(arr[0], arr[1])) {
							if (y > arr[1] || (y == arr[1] && x > arr[0])) {
								x = arr[0];
								y = arr[1];
							}
						}
					}
					
					shark.x = x;
					shark.y = y;
					map[y][x] = 0;
					
					if (++shark.count == shark.size) {
						shark.size++;
						shark.count = 0;
					}
					return time;
				}
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (isInside(nx, ny) && !visited[ny][nx]) {
						if (map[ny][nx] > shark.size) {
							continue;
						}
						q.add(new int[] { nx, ny });
						visited[ny][nx] = true;
					}
				}
			}
			time++;
		}
		return 0;
	}
	
	private static boolean isSmall(int x, int y) {
		return map[y][x] != 0 && map[y][x] < shark.size;
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
	
	private static class Shark {
		int x, y;
		int size = 2;
		int count = 0;
		
		public Shark(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
