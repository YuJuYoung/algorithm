package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_2234 {
	
	private static List<Integer> size = new ArrayList<>();
	private static int[][] map;
	private static int[][] cache;
	
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		cache = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int num = 1;
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (cache[i][j] == 0) {
					int tmp = dfs(j, i, num);
					
					max = Math.max(tmp, max);
					size.add(tmp);
					num++;
				}
			}
		}
		sb.append(num - 1).append('\n');
		sb.append(max).append('\n');
		
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if ((map[y][x] & (1 << i)) != 0) {
						if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
							if (cache[y][x] == cache[ny][nx]) {
								continue;
							}
							max = Math.max(size.get(cache[y][x] - 1) + size.get(cache[ny][nx] - 1), max);
						}
					}
				}
			}
		}
		System.out.println(sb.append(max));
	}
	
	private static int dfs(int x, int y, int num) {
		cache[y][x] = num;
		
		int tmp = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if ((map[y][x] & (1 << i)) == 0 && cache[ny][nx] == 0) {
				tmp += dfs(nx, ny, num);
			}
		}
		return tmp;
	}

}
