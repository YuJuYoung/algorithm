package BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem_9376 {
	
	private static int h, w;
	private static char[][] map;
	private static int[][][] counts;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h + 2][w + 2];
			counts = new int[h + 2][w + 2][3];
			
			Deque<int[]> dq = new LinkedList<>();
			int idx = 0;
			
			for (int i = 1; i <= h; i++) {
				String str = br.readLine();
				
				for (int j = 1; j <= w; j++) {
					map[i][j] = str.charAt(j - 1);
					
					if (map[i][j] == '$') {
						dq.add(new int[] { i, j, 1, idx });
						counts[i][j][idx++] = 1;
					}
				}
			}
			dq.add(new int[] { 0, 0, 1, idx });
			counts[0][0][idx] = 1;
			
			bw.write(solve(dq) + "\n");
		}
		bw.close();
	}
	
	private static int solve(Deque<int[]> dq) {
		int min = Integer.MAX_VALUE;
		
		int[] dx = { 0, 1, -1, 0 };
		int[] dy = { 1, 0, 0, -1 };
		
		while (!dq.isEmpty()) {
			int[] node = dq.pollFirst();
			
			int x = node[1];
			int y = node[0];
			int count = node[2];
			int idx = node[3];
			
			if (counts[y][x][0] != 0 && counts[y][x][1] != 0 && counts[y][x][2] != 0) {
				int sum = counts[y][x][0] + counts[y][x][1] + counts[y][x][2] - 3;
				
				if (map[y][x] == '#') {
					min = Math.min(min, sum - 2);
				} else {
					min = Math.min(min, sum);
				}
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (isInside(nx, ny) && map[ny][nx] != '*' && counts[ny][nx][idx] == 0) {
					if (map[ny][nx] == '#') {
						dq.addLast(new int[] { ny, nx, count + 1, idx });
						counts[ny][nx][idx] = count + 1;
					} else {
						dq.addFirst(new int[] { ny, nx, count, idx });
						counts[ny][nx][idx] = count;
					}
				}
			}
		}
		return min;
	}
	
	private static boolean isInside(int x, int y) {
		return !(x < 0 || x > w + 1 || y < 0 || y > h + 1);
	}

}
