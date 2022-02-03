package ±¸Çö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_17822 {
	
	private static int N, M, T, tot, sum = 0;
	private static int[][] circle;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		tot = N * M;
		
		circle = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				circle[i][j] = Integer.parseInt(st.nextToken());
				sum += circle[i][j];
			}
		}
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			cycle(i, x - 1, d, k);
		}
		
		System.out.println(sum);
	}
	
	private static void cycle(int T, int x, int d, int k) {
		int[] newArray = new int[M];
		
		for (int i = 0; i < M; i++) {
			if (d == 0) {
				circle[x][i] = circle[x][goLeft(i, k)];
			} else {
				circle[x][i] = circle[x][goRight(i, k)];
			}
		}
		circle[x] = newArray;
		
		if ((T == 0 ? eraze(0, N) :eraze(x, x + 1)) == 0) {
			int avg = sum / tot;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0 ; j < M; j++) {
					if (circle[i][j] == 0 || circle[i][j] == avg) {
						continue;
					}
					
					if (circle[i][j] < avg) {
						circle[i][j]++;
					} else {
						circle[i][j]--;
					}
				}
			}
		}
	}
	
	private static int eraze(int startI, int endI) {
		int cnt = 0;
		
		for (int i = startI; i < endI; i++) {
			for (int j = 0; j < M; j++) {
				cnt += dfs(j, i, circle[i][j]);
			}
		}
		return cnt;
	}
	
	private static int dfs(int x, int y, int num) {
		if (circle[y][x] == 0 || circle[y][x] != num) {
			return 0;
		}
		circle[y][x] = 0;
		
		int cnt = 1;
		
		if (y > 0) {
			cnt += dfs(x, y - 1, num);
		}
		if (y < N - 1) {
			cnt += dfs(x, y + 1, num);
		}
		cnt += dfs(goRight(x, 1), y, num);
		cnt += dfs(goLeft(x, 1), y, num);
		
		return cnt;
	}
	
	private static int goRight(int idx, int k) {
		int right = idx + k;
		
		if (right < M) {
			return right;
		}
		return right % M;
	}
	
	private static int goLeft(int idx, int k) {
		int left = idx - k;
		
		if (left >= 0) {
			return left;
		}
		return M - left;
	}

}
