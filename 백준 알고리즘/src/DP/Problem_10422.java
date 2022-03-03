package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_10422 {
	
	private static long[] count = getCount();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
			bw.write(count[Integer.parseInt(br.readLine())] + "\n");
		}
		bw.close();
	}
	
	private static long[] getCount() {
		long[] count = new long[5001];
		count[0] = count[2] = 1;
		
		for (int i = 4; i <= 5000; i += 2) {
			for (int j = 0; j <= i - 2; j += 2) {
				count[i] += count[j] * count[i - j - 2];
				count[i] %= 1000000007;
			}
		}
		return count;
	}

}
