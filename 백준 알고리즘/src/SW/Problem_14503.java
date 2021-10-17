package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_14503 {
	
	private static char[][] map;
	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j * 2);
			}
		}
		
		map[y][x] = '2';
		System.out.println(run(x, y, d, 1));
	}
	
	private static int run(int x, int y, int d, int c) {
		for (int i = 0; i < 4; i++) {
			d = d == 0 ? 3 : d - 1;
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (map[ny][nx] == '0') {
				map[ny][nx] = '2';
				return run(nx, ny, d, c + 1);
			}
		}
		int back = (d + 2) % 4;
		int nx = x + dx[back];
		int ny = y + dy[back];
		
		if (map[ny][nx] != '1') {
			return run(nx, ny, d, c);
		}
		return c;
	}

}
