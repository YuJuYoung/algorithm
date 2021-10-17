package ±×¸®µð;

import java.io.*;
import java.util.StringTokenizer;

public class Problem_1946 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
			int N = Integer.parseInt(br.readLine());
			int[] score = new int[N + 1];
			while (N-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				score[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
			}
			int min = score[1], count = 1;
			for (int i = 2; i <= score.length; i++) {
				if (min == 1) {
					break;
				}
				if (min > score[i]) {
					min = score[i];
					count++;
				}
			}
			bw.write(count + "\n");
		}
		bw.close();
	}

}
