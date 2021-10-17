package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_17143 {
	
	private static int R, C, index = 0;
	private static Shark[][][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new Shark[2][R][C];
		
		for (int M = Integer.parseInt(st.nextToken()); M > 0; M--) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[0][r][c] = new Shark(s, d, z);
		}
		
		int ans = 0;
		for (int j = 0; j < C - 1; j++) {
			ans += fishing(j);
			move(j);
		}
		System.out.println(ans + fishing(C - 1));
	}
	
	private static int fishing(int j) {
		for (int i = 0; i < R; i++) {
			if (map[index][i][j] != null) {
				Shark shark = map[index][i][j];
				map[index][i][j] = null;
				
				return shark.z;
			}
		}
		return 0;
	}
	
	private static void move(int t) {
		int next = (index + 1) % 2;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[index][i][j] != null) {
					Shark shark = map[index][i][j];
					map[index][i][j] = null;
					
					int x = j, y = i;
					int s = shark.s;
					int d = shark.d;
					int z = shark.z;
					
					boolean flag = false;
					if (d == 1) {
						if ((y -= s) < 0) {
							if (y / (R - 1) % 2 == 0) {
								flag = true;
							}
							y = R - 1 + y % (R - 1);
						}
					} else if (d == 2) {
						if ((y += s) >= R) {
							if (y / (R - 1) % 2 == 0) {
								flag = true;
							}
							y %= R - 1;
						}
					} else if (d == 3) {
						if ((x += s) >= C) {
							if (x / (C - 1) % 2 == 0) {
								flag = true;
							}
							x %= C - 1;
						}
					} else {
						if ((x -= s) < 0) {
							if (x / (C - 1) % 2 == 0) {
								flag = true;
							}
							x = C - 1 + x % (C - 1);
						}
					}
					if (flag) {
						d = turn(d);
					}
					if (map[next][y][x] != null && map[next][y][x].z > z) {
						continue;
					}
					shark.d = d;
					map[next][y][x] = shark;
				}
			}
		}
		index = next;
	}
	
	private static int turn(int d) {
		if (d == 1) {
			return 2;
		} else if (d == 2) {
			return 1;
		} else if (d == 3) {
			return 4;
		} else {
			return 3;
		}
	}
	
	private static class Shark {
		int s, d, z;
		
		public Shark(int s, int d, int z) {
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

}