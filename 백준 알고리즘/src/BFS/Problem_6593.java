package BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_6593 {
	
	private static int L, R, C;
	private static char[][][] map;
	
	private static Queue<Point> q;
	private static int[] dx = { 1, 0, 0, -1, 0, 0 }, dy = { 0, 1, -1, 0, 0, 0 }, dz = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken());
			if (L == 0) {
				break;
			}
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[L][R][C];
			q = new LinkedList<>();
			
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String str = br.readLine();
					
					for (int k = 0; k < C; k++) {
						map[i][j][k] = str.charAt(k);
						
						if (map[i][j][k] == 'S') {
							q.add(new Point(k, j, i));
							map[i][j][k] = '#';
						}
					}
				}
				br.readLine();
			}
			bw.write(bfs());
		}
		bw.close();
	}
	
	private static String bfs() {
		int time = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				Point tmp = q.poll();
				int x = tmp.x;
				int y = tmp.y;
				int z = tmp.z;
				
				for (int i = 0; i < 6; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					int nz = z + dz[i];
					
					if (isInside(nx, ny, nz) && map[nz][ny][nx] != '#') {
						if (map[nz][ny][nx] == 'E') {
							return "Escaped in " + time + " minute(s).\n";
						}
						q.add(new Point(nx, ny, nz));
						map[nz][ny][nx] = '#';
					}
				}
			}
			time++;
		}
		return "Trapped!\n";
	}
	
	private static boolean isInside(int x, int y, int z) {
		return x >= 0 && x < C && y >= 0 && y < R && z >= 0 && z < L;
	}
	
	private static class Point {
		int x, y, z;
		
		public Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

}
