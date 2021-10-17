package DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_4902 {
	
	private static int[][] cache;
	private static int n, time = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			if ((n = Integer.parseInt(st.nextToken())) == 0) {
				break;
			}
			cache = new int[n][n * 2 - 1];
			int ans = Integer.MIN_VALUE;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < (i + 1) * 2 - 1; j++) {
					cache[i][j] = Integer.parseInt(st.nextToken());
					
					if (j > 0) {
						cache[i][j] += cache[i][j - 1];
					}
					if (j % 2 == 0) {
						ans = Math.max(ans, max(i, j));
					}
				}
			}
			bw.write(time++ + ". " + ans);
			bw.newLine();
		}
		bw.close();
	}
	
	private static int max(int i, int j) {
		int max = Integer.MIN_VALUE;
		
		for (int k = 1; k <= j / 2 + 1; k++) {
			int area = 0;
			int x = j, y = i;
			
			for (int l = k; l > 0; l--) {
				int tmp = cache[y][x];
				int cut = x - l * 2 + 1;
				
				if (cut > -1) {
					tmp -= cache[y][cut];
				}
				area += tmp;
				x -= 2;
				y--;
			}
			max = Math.max(max, area);
		}
		return max;
	}

}
