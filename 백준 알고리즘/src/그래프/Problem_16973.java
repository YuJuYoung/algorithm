package ±×·¡ÇÁ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_16973 {
	
	private static int N, M;
	private static int H, W;
	private static int sr, sc, fr, fc;
	
	private static int[][] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sum = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= M; j++) {
				sum[i][j] = Integer.parseInt(st.nextToken());
				sum[i][j] = sum[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		fr = Integer.parseInt(st.nextToken());
		fc = Integer.parseInt(st.nextToken());
		
		if (sr == fr && sc == fc) {
			System.out.println(0);
		} else {
			System.out.println(solve());
		}
	}
	
	private static int solve() {
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N + 1][M + 1];
		
		q.add(new int[] { sc, sr });
		visited[sr][sc] = true;
		
		int time = 1;
		
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				int[] node = q.poll();
				
				int x = node[0];
				int y = node[1];
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (isPossible(nx, ny) && !visited[ny][nx]) {
						if (nx == fc && ny == fr) {
							return time;
						}
						q.add(new int[] { nx, ny });
						visited[ny][nx] = true;
					}
				}
			}
			time++;
		}
		return -1;
	}
	
	private static boolean isPossible(int x, int y) {
		if (x > 0 && x <= M && y > 0 && y <= N) {
			int fx = x + W - 1;
			int fy = y + H - 1;
			
			if (fx > 0 && fx <= M && fy > 0 && fy <= N) {
				if (sum[fy][fx] - sum[fy][x - 1] - sum[y - 1][fx] + sum[y - 1][x - 1] == 0) {
					return true;
				}
			}
		}
		return false;
	}

}
