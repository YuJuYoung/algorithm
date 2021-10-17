package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2842 {
	
	private static int N;
	private static char[][] map;
	private static int[][] height;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		height = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				
			}
		}
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; i < N; j++) {
				height[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}
