package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_3055 {
	
	private static int R, C;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	
	private static Queue<int[]> water = new LinkedList<>();;
	private static Queue<int[]> S = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				
				if (map[i][j] == '*') {
					water.add(new int[] { j, i });
				}
				if (map[i][j] == 'S') {
					S.add(new int[] { j, i });
					map[i][j] = '.';
					visited[i][j] = true;
				}
			}
		}
		int time = bfs();
		System.out.println(time == -1 ? "KAKTUS" : time);
	}
	
	private static int bfs() {
		int time = 1;
		while (!S.isEmpty()) {
			fillUpWater();
			int size = S.size();
			
			while (size-- > 0) {
				int[] temp = S.poll();
				int x = temp[0];
				int y = temp[1];
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (isInside(nx, ny) && !visited[ny][nx]) {
						if (map[ny][nx] == 'D') {
							return time;
						}
						if (map[ny][nx] == '.') {
							S.add(new int[] { nx, ny });
							visited[ny][nx] = true;
						}
					}
				}
			}
			time++;
		}
		return -1;
	}
	
	private static void fillUpWater() {
		int size = water.size();
		
		while (size-- > 0) {
			int[] temp = water.poll();
			int x = temp[0];
			int y = temp[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (isInside(nx, ny) && map[ny][nx] == '.') {
					map[ny][nx] = '*';
					water.add(new int[] { nx, ny });
				}
			}
		}
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < C && y >= 0 && y < R;
	}

}
