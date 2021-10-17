package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_15684 {
	
	private static int N, M, H;
	private static boolean[][] line;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		line = new boolean[H + 1][N + 1];
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			line[a][b] = true;
		}
		
		for (int i = 0; i <= 3; i++) {
			if (dfs(1, 1, 0, i)) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}
	
	private static boolean dfs(int lastY, int lastX, int c, int max) {
		if (c == max) {
			if (check()) {
				return true;
			}
			return false;
		} else {
			for (int i = lastY; i <= H; i++) {
				for (int j = lastX; j < N; j++) {
					if (!line[i][j] && !line[i][j - 1] && !line[i][j + 1]) {
						line[i][j] = true;
						
						if (dfs(i, j + 2, c + 1, max)) {
							return true;
						}
						line[i][j] = false;
					}
				}
			}
		}
		return false;
	}
	
	private static boolean check() {
		for (int i = 1; i <= N; i++) {
			int x = i, y = 1;
			
			while (y <= H) {
				if (line[y][x - 1]) {
					x--;
				} else if (line[y][x]) {
					x++;
				}
				y++;
			}
			
			if (x != i) {
				return false;
			}
		}
		return true;
	}

}
