package ±¸Çö;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_15953 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] A = { 0, 500, 300, 200, 50, 30, 10 };
		int[] B = { 512, 256, 128, 64, 32 };
		
		for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
			String[] arr = br.readLine().split(" ");
			
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			int sum = 0;
			
			if (a != 0) {
				int n = 0;
				
				for (int i = 1; i <= 6; i++) {
					n += i;
					
					if (a <= n) {
						sum += A[i];
						break;
					}
				}
			}
			if (b != 0) {
				int n = 0;
				
				for (int i = 0; i <= 4; i++) {
					n += (int) Math.pow(2, i);
					
					if (b <= n) {
						sum += B[i];
						break;
					}
				}
			}
			bw.write(sum * 10000 + "\n");
		}
		bw.close();
	}

}
