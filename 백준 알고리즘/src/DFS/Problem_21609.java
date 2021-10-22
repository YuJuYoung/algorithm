package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
			int[] maxStandard = null;
			int maxRainbow = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] < 0) {
						continue;
					}
					boolean[][] visited = new boolean[N][N];
					
					List<int[]> list = new ArrayList<>();
					int[] standard = { j, i };
					int rainbow = dfs(j, i, map[i][j], list, visited, standard);
					
					if (list.size() < 2) {
						continue;
					}
					
					if (maxList == null) {
						maxList = list;
						maxRainbow = rainbow;
						maxStandard = standard;
					} else {
						if (maxList.size() < list.size()) {
							maxList = list;
							maxRainbow = rainbow;
							maxStandard = standard;
							continue;
						}
						if (maxList.size() == list.size()) {
							if (rainbow > maxRainbow) {
								maxList = list;
								maxRainbow = rainbow;
								maxStandard = standard;
								continue;
							}
							if (standard[1] > maxStandard[1] || (standard[1] == maxStandard[1] && standard[0] > maxStandard[0])) {
								maxList = list;
								maxRainbow = rainbow;
								maxStandard = standard;
							}
						}
					}
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
	
	private static int dfs(int x, int y, int color, List<int[]> list, boolean[][] visited, int[] standard) {
		if (standard[1] > y || (standard[1] == y && standard[0] > x)) {
			standard[0] = x;
			standard[1] = y;
		}
		visited[y][x] = true;
		
		int rainbow = map[y][x] == 0 ? 1 : 0;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (isInside(nx, ny) && !visited[ny][nx] && (map[ny][nx] == 0 || map[ny][nx] == color)) {
				rainbow += dfs(x + dx[i], y + dy[i], color, list, visited, standard);
			}
		}
		list.add(new int[] { x, y });
		return rainbow;
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
