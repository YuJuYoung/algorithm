package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_10422 {
	
	private static int[] count = getCount();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
			bw.write(count[Integer.parseInt(br.readLine())] + "\n");
		}
		bw.close();
	}
	
	private static int[] getCount() {
		int[] count = new int[5001];
		count[2] = 1;
		
		for (int i = 4; i <= 5000; i += 2) {
			count[i] = count[i - 2] * 2 % 1000000007;
		}
		return count;
	}

}
