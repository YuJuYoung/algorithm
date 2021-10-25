package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_21609 {
	private static int N, M;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int score = 0;
		
		while (true) {
			List<int[]> maxList = null;
			boolean[][] visited = new boolean[N][N];
			
			int[] maxStd = null;
			int maxRainbow = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] <= 0 || visited[i][j]) {
						continue;
					}
					
					List<int[]> list = new ArrayList<>();
					
					int[] result = bfs(j, i, list, visited);
					int rainbow = result[0];
					int[] std = { result[1], result[2] };
					
					for (int[] point : list) {
						visited[point[1]][point[0]] = false;
					}
					if (list.size() < 2) {
						continue;
					}
					
					if (maxList != null) {
						if (list.size() < maxList.size()) {
							continue;
						}
						if (list.size() == maxList.size()) {
							if (rainbow < maxRainbow) {
								continue;
							}
							if (rainbow == maxRainbow) {
								if (std[1] < maxStd[1]) {
									continue;
								}
								if (std[1] == maxStd[1]) {
									if (std[0] < maxStd[0]) {
										continue;
									}
								}
							}
						}
					}
					maxList = list;
					maxRainbow = rainbow;
					maxStd = std;
				}
			}
			
			if (maxList == null) {
				break;
			}
			score += maxList.size() * maxList.size();
			
			for (int[] point : maxList) {
				map[point[1]][point[0]] = -2;
			}
			
			applyGravity();
			turn();
			applyGravity();
		}
		System.out.println(score);
	}
	
	private static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
	
	/*private static int dfs(int x, int y, int color, List<int[]> list, boolean[][] visited, int[] std) {
		if (map[y][x] > 0 && (y < std[1] || (std[1] == y && x < std[0]))) {
			std[0] = x;
			std[1] = y;
		}
		visited[y][x] = true;
		
		int rainbow = map[y][x] == 0 ? 1 : 0;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (isInside(nx, ny) && (map[ny][nx] == 0 || map[ny][nx] == color) && !visited[ny][nx]) {
				rainbow += dfs(x + dx[i], y + dy[i], color, list, visited, std);
			}
		}
		list.add(new int[] { x, y });
		return rainbow;
	}*/
	
	private static int[] bfs(int x, int y, List<int[]> list, boolean[][] visited) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] { x, y });
		visited[y][x] = true;
		
		int stdX = x, stdY = y;
		int rainbow = 0;
		int color = map[y][x];
		
		while (!q.isEmpty()) {
			int[] pair = q.poll();
			int px = pair[0], py = pair[1];
			
			list.add(new int[] { px, py });
			
			if (map[py][px] != 0) {
				if (py < stdY || (py == stdY && px < stdX)) {
					stdX = px;
					stdY = py;
				}
			} else {
				rainbow++;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				
				if (isInside(nx, ny) && (map[ny][nx] == 0 || map[ny][nx] == color) && !visited[ny][nx]) {
					q.add(new int[] { nx, ny });
					visited[ny][nx] = true;
				}
			}
		}
		return new int[] { rainbow, stdX, stdY };
	}
	
	private static boolean isInside(int x, int y) {
		return x < N && x >= 0 && y < N && y >= 0;
	}
	
	private static void applyGravity() {
		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == -2) {
					int ni = i;
					
					while (ni-- > 0) {
						if (map[ni][j] == -1) {
							break;
						}
						if (map[ni][j] >= 0) {
							map[i][j] = map[ni][j];
							map[ni][j] = -2;
							break;
						}
					}
				}
			}
		}
	}
	
	private static void turn() {
		int[][] tmp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = map[j][N - i - 1];
			}
		}
		map = tmp;
	}

}
