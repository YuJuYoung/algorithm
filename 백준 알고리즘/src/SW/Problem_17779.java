package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_17779 {
	
	private static int N, sum;
	private static int[][] area;
	private static boolean[][] area5Line;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		area = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				sum += area[i][j];
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for (int x = 1; x < N - 1; x++) {
			for (int y = 2; y < N; y++) {
				for (int d1 = 1; y - d1 > 0; d1++) {
					for (int d2 = 1; x + d1 + d2 <= N && y + d2 <= N; d2++) {
						setArea5Line(x, y, d1, d2);
						
						int area1 = area1(x, y, d1);
						int area2 = area2(x, y, d2);
						int area3 = area3(x, y, d1, d2);
						int area4 = area4(x, y, d1, d2);
						int area5 = sum - area1 - area2 - area3 - area4;
						
						int[] sumOfAreas = { area2, area3, area4, area5 };
						int min = area1, max = area1;
						for (int i = 0; i < 4; i++) {
							min = Math.min(min, sumOfAreas[i]);
							max = Math.max(max, sumOfAreas[i]);
						}
						ans = Math.min(ans, max - min);
					}
				}
			}
		}
		System.out.println(ans);
	}
	
	private static void setArea5Line(int x, int y, int d1, int d2) {
		area5Line = new boolean[N + 1][N + 1];
		for (int i = 0; i <= d1; i++) {
			area5Line[x + i][y - i] = true;
		}
		for (int i = 0; i <= d2; i++) {
			area5Line[x + i][y + i] = true;
		}
		for (int i = 0; i <= d2; i++) {
			area5Line[x + d1 + i][y - d1 + i] = true;
		}
		for (int i = 0; i <= d1; i++) {
			area5Line[x + d2 + i][y + d2 - i] = true;
		}
	}
	
	private static int area1(int x, int y, int d1) {
		int result = 0;
		for (int r = 1; r < x + d1; r++) {
			for (int c = 1; c <= y; c++) {
				if (area5Line[r][c]) {
					break;
				}
				result += area[r][c];
			}
		}
		return result;
	}
	
	private static int area2(int x, int y, int d2) {
		int result = 0;
		for (int r = 1; r <= x + d2; r++) {
			for (int c = N; c > y; c--) {
				if (area5Line[r][c]) {
					break;
				}
				result += area[r][c];
			}
		}
		return result;
	}
	
	private static int area3(int x, int y, int d1, int d2) {
		int result = 0;
		for (int r = x + d1; r <= N; r++) {
			for (int c = 1; c < y - d1 + d2; c++) {
				if (area5Line[r][c]) {
					break;
				}
				result += area[r][c];
			}
		}
		return result;
	}
	
	private static int area4(int x, int y, int d1, int d2) {
		int result = 0;
		for (int r = x + d2 + 1; r <= N; r++) {
			for (int c = N; c >= y - d1 + d2; c--) {
				if (area5Line[r][c]) {
					break;
				}
				result += area[r][c];
			}
		}
		return result;
	}

}
