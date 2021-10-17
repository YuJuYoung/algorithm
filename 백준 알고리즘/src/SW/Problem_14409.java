package SW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_14409 {
	
	private static int N, M, cur = 0;
	private static int[] dice = new int[6];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		while (K-- > 0) {
			int n = Integer.parseInt(st.nextToken());
			int nx = x;
			int ny = y;
			
			if (n == 1) {
				ny++;
			} else if (n == 2) {
				ny--;
			} else if (n == 3) {
				nx--;
			} else {
				nx++;
			}
			if (!isInside(nx, ny)) {
				continue;
			}
			x = nx;
			y = ny;
		}
		bw.close();
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}
