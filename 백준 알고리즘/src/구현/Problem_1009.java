package 구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_1009 {
	
	private static int[][] ans = { { 10, 10, 10, 10 }, { 1, 1, 1, 1 }, { 6, 2, 4, 8 },
			{ 1, 3, 9, 7 }, { 6, 4, 6, 4 }, { 5, 5, 5, 5 }, { 6, 6, 6, 6 },
			{ 1, 7, 9, 3 }, { 6, 8, 4, 2 }, { 1, 9, 1, 9 }};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			bw.write(ans[a % 10][b % 4] + "\n");
		}
		bw.close();
	}

}
