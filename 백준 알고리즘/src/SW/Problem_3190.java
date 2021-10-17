package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_3190 {
	
	private static int N, ans;
	private static int[][] cache;
	private static boolean[][] apple;
	private static char[] turn = new char[10001];
	
	private static int[] dx = { 1, 0, -1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		cache = new int[N][N];
		apple = new boolean[N][N];
		
		while (K-- > 0) {
			String[] arr = br.readLine().split(" ");
			
			int y = Integer.parseInt(arr[0]);
			int x = Integer.parseInt(arr[1]);
			apple[y - 1][x - 1] = true;
		}
		
		for (int L = Integer.parseInt(br.readLine()); L > 0; L--) {
			String[] arr = br.readLine().split(" ");
			
			int n = Integer.parseInt(arr[0]);
			turn[n] = arr[1].charAt(0);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cache[i][j] = -1;
			}
		}
		dfs(0, 0, 0, 1, 0);
		
		System.out.println(ans);
	}
	
	private static void dfs(int x, int y, int d, int len, int time) {
		if (!isInside(x, y) || (cache[y][x] != -1 && cache[y][x] >= time - len)) {
			ans = time;
		} else {
			cache[y][x] = time;
			
			if (turn[time] != '\u0000') {
				if (turn[time] == 'L') {
					d = d == 0 ? 3 : d - 1;
				} else {
					d = d == 3 ? 0 : d + 1;
				}
			}
			if (apple[y][x]) {
				apple[y][x] = false;
				len++;
			}
			dfs(x + dx[d], y + dy[d], d, len, time + 1);
		}
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
