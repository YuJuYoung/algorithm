package 그리디;

import java.io.*;
import java.util.*;

public class Problem_11501 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			long answer = 0;
			int max = 0;
			for (int i = N - 1; i >= 0; i--) {
				max = Math.max(max, arr[i]);
				answer += max - arr[i];
			}
			bw.write(answer + "\n");
		}
		bw.close();
	}

}
