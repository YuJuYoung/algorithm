package ±¸Çö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_17135 {
	
	private static int N, M, D, ans = 0;
	
	private static int[] archers = new int[3];
	
	private static int[][] map;
	private static int[][] copiedMap;
	
	private static int[][] visited;
	private static int visitNum = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken()) - 1;
		
		map = new int[N][M];
		copiedMap = new int[N][M];
		visited = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		play(-1, 0);
		System.out.println(ans);
	}
	
	private static void play(int last, int archer) {
		if (archer == 3) {
			ans = Math.max(ans, getScore());
		} else {
			for (int i = last + 1; i <= M - 3 + archer; i++) {
				play(archers[archer] = i, archer + 1);
			}
		}
	}
	
	private static int getScore() {
		int[][] attacked = new int[3][2];
		int score = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copiedMap[i][j] = map[i][j];
			}
		}
		
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < 3; j++) {
				attacked[j] = attack(archers[j], i);
			}
			
			for (int[] pair : attacked) {
				if (pair == null) {
					continue;
				}
				int x = pair[0], y = pair[1];
				
				if (copiedMap[y][x] == 1) {
					score++;
				}
				copiedMap[y][x] = 0;
			}
		}
		return score;
	}
	
	private static int[] dx = { -1, 0, 1 }, dy = { 0, -1, 0 };
	
	private static int[] attack(int j, int i) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] { j, i, 0 });
		visited[i][j] = ++visitNum;
		
		while (!q.isEmpty()) {
			int[] pair = q.poll();
			
			int x = pair[0];
			int y = pair[1];
			int d = pair[2];
			
			if (copiedMap[y][x] == 1) {
				return new int[] { x, y };
			}
			if (d == D) {
				continue;
			}
			
			for (int k = 0; k < 3; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if (isInside(nx, ny) && visited[ny][nx] != visitNum) {
					q.add(new int[] { nx, ny, d + 1 });
					visited[ny][nx] = visitNum;
				}
			}
		}
		return null;
	}
	
	private static boolean isInside(int x, int y) {
		return !(x < 0 || x == M || y < 0 || y == N);
	}

}
