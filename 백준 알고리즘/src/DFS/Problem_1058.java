package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1058 {
	
	private static int N;
	private static boolean[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < N; j++) {
				if (str.charAt(j) == 'Y') {
					arr[i][j] = true;
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			int count = 0;
			
			for (int j = 0; j < N; j++) {
				if (check(i, j)) {
					count++;
				}
			}
			
			if (max < count) {
				max = count;
			}
		}
		System.out.println(max);
	}
	
	private static boolean check(int i, int j) {
		if (i == j) {
			return false;
		}
		
		if (arr[i][j]) {
			return true;
		}
		for (int k = 0; k < N; k++) {
			if (arr[k][i] && arr[j][k]) {
				return true;
			}
		}
		return false;
	}

}
