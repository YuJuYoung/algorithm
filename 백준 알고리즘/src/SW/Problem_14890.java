package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_14890 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			boolean isRoad = true;
			
			for (int j = 0; j < N - 1; j++) {
				if (j + L < N) {
					if (map[i][j + L] == map[i][j] + 1 || map[i][j + L] == map[i][j] - 1) {
						boolean isPossible = true;
						
						int tmp = map[i][j + L] == map[i][j] + 1 ? map[i][j] : map[i][j + L];
						for (int k = j + 1; k < j + L; k++) {
							if (map[i][k] != tmp) {
								isPossible = false;
								break;
							}
						}
						
						if (isPossible) {
							j = j + L - 1;
							continue;
						} else {
							isRoad = false;
							break;
						}
					}
				}
				
				if (map[i][j + 1] != map[i][j]) {
					isRoad = false;
					break;
				}
			}
			
			if (isRoad) {
				ans++;
			}
		}
		for (int i = 0; i < N; i++) {
			boolean isRoad = true;
			
			for (int j = 0; j < N - 1; j++) {
				if (j + L < N) {
					if (map[j + L][i] == map[j][i] + 1 || map[j + L][i] == map[j][i] - 1) {
						boolean isPossible = true;
						
						for (int k = j + 1; k < j + L; k++) {
							if (map[k][i] != map[j + 1][i]) {
								isPossible = false;
								break;
							}
						}
						
						if (isPossible) {
							j = j + L - 1;
							continue;
						}
					}
				}
				
				if (map[j + 1][i] != map[j][i]) {
					isRoad = false;
					break;
				}
			}
			
			if (isRoad) {
				ans++;
			}
		}
		System.out.println(ans);
	}

}
