package ±×¸®µð;

import java.io.*;

public class Problem_10162 {
	private static final int[] TIME = { 300, 60, 10 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		if (T % 10 != 0) {
			bw.write(-1 + "\n");
		} else {
			for (int time : TIME) {
				int count = 0;
				while (T >= time) {
					T -= time;
					count++;
				}
				bw.write(count + " ");
			}
		}
		bw.close();
	}

}
