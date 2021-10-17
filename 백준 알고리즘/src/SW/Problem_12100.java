package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_12100 {
	
	private static int N, max = 0;
	private static boolean[][] changed;
	
	private static Queue<int[][]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if (max < arr[i][j]) {
					max = arr[i][j];
				}
			}
		}
		q.add(arr);
		
		System.out.println(bfs());
	}
	
	private static int bfs() {
		int time = 5;
		while (!q.isEmpty() && time-- > 0) {
			int size = q.size();
			
			while (size-- > 0) {
				int[][] arr = q.poll();
				
				up(arr);
				down(arr);
				right(arr);
				left(arr);
			}
		}
		return max;
	}
	
	private static void left(int[][] arr) {
		int[][] tmp = clone(arr);
		boolean moved = false;
		
		changed = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (tmp[i][j] != 0 && move(tmp, j, i, -1, 0)) {
					moved = true;
				}
			}
		}
		if (moved) {
			q.add(tmp);
		}
	}
	
	private static void right(int[][] arr) {
		int[][] tmp = clone(arr);
		boolean moved = false;
		
		changed = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = N - 2; j >= 0; j--) {
				if (tmp[i][j] != 0 && move(tmp, j, i, 1, 0)) {
					moved = true;
				}
			}
		}
		if (moved) {
			q.add(tmp);
		}
	}
	
	private static void up(int[][] arr) {
		int[][] tmp = clone(arr);
		boolean moved = false;
		
		changed = new boolean[N][N];
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (tmp[i][j] != 0 && move(tmp, j, i, 0, -1)) {
					moved = true;
				}
			}
		}
		if (moved) {
			q.add(tmp);
		}
	}
	
	private static void down(int[][] arr) {
		int[][] tmp = clone(arr);
		boolean moved = false;
		
		changed = new boolean[N][N];
		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				if (tmp[i][j] != 0 && move(tmp, j, i, 0, 1)) {
					moved = true;
				}
			}
		}
		if (moved) {
			q.add(tmp);
		}
	}
	
	private static boolean move(int[][] tmp, int x, int y, int dx, int dy) {
		int nx = x + dx;
		int ny = y + dy;
		
		while (true) {
			if (nx == -1 || nx == N || ny == -1 || ny == N) {
				tmp[ny - dy][nx - dx] = tmp[y][x];
				tmp[y][x] = 0;
				break;
			}
			
			if (tmp[ny][nx] != 0) {
				if (tmp[y][x] == tmp[ny][nx] && !changed[ny][nx]) {
					tmp[ny][nx] = tmp[ny][nx] * 2;
					changed[ny][nx] = true;
					
					if (max < tmp[ny][nx]) {
						max = tmp[ny][nx];
					}
				} else {
					if (x + dx == nx && y + dy == ny) {
						return false;
					}
					tmp[ny - dy][nx - dx] = tmp[y][x];
				}
				tmp[y][x] = 0;
				break;
			}
			nx += dx;
			ny += dy;
		}
		return true;
	}
	
	private static int[][] clone(int[][] arr) {
		int[][] tmp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
		return tmp;
	}

}
