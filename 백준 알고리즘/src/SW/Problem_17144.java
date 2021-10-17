package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_17144 {
	
	private static int R, C, T;
	private static int[][] map;
	private static int[][] cache;
	private static int[] cleaner = new int[2];;
	
	private static int[] dx = { 0, 1, 0, -1 };
	private static int[][] dy = { { -1, 0, 1, 0 }, { 1, 0, -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		cache = new int[R][C];
		
		int idx = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == -1) {
					cleaner[idx++] = i;
				}
			}
		}
		
		while (true) {
			spread();
			wind();
			
			if (--T == 0) {
				break;
			}
			for (int i = 0; i < R; i++) {
				Arrays.fill(cache[i], 0);
			}
		}
		
		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				ans += map[i][j];
			}
		}
		System.out.println(ans + 2);
	}
	
	private static void wind() {
		int tmp = -1;
		int other = 1;
		
		for (int i = 0; i < 2; i++) {
			int cx = 0;
			int cy = cleaner[i] + tmp;
			int d = 0;
			
			while (true) {
				int nx = cx + dx[d];
				int ny = cy + dy[i][d];
				
				if (!isInside(nx, ny) || ny == cleaner[other]) {
					d++;
				} else {
					if (map[ny][nx] == -1) {
						map[cy][cx] = 0;
						break;
					}
					map[cy][cx] = map[ny][nx];
					cy = ny;
					cx = nx;
				}
			}
			tmp += 2;
			other = 0;
		}
	}
	
	private static void spread() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0 && map[i][j] > 4) {
					int dvd = map[i][j] / 5;
					int cnt = 0;
					
					for (int k = 0; k < 4; k++) {
						int nx = j + dx[k];
						int ny = i + dy[0][k];
						
						if (isInside(nx, ny) && map[ny][nx] != -1) {
							cache[ny][nx] += dvd;
							cnt++;
						}
					}
					map[i][j] -= dvd * cnt;
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] += cache[i][j];
			}
		}
	}
	
	private static boolean isInside(int x, int y) {
		return !(x == -1 || x == C || y == -1 || y == R);
	}

}
