package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1236 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int a = 0, b = 0;
		
		for (int i = 0; i < N; i++) {
			boolean blocked = false;
			
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'X') {
					blocked = true;
					break;
				}
			}
			
			if (!blocked) {
				a++;
			}
		}
		
		for (int j = 0; j < M; j++) {
			boolean blocked = false;
			
			for (int i = 0; i < N; i++) {
				if (map[i][j] == 'X') {
					blocked = true;
					break;
				}
			}
			
			if (!blocked) {
				b++;
			}
		}
		System.out.println(Math.max(a, b));
	}

}
