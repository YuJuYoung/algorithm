package ¼öÇÐ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem_2981 {
	
	private static int N;
	private static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int gcd = arr[1] - arr[0];
		
		for (int i = 2; i < N; i++) {
			gcd = getGcd(gcd, arr[i] - arr[i - 1]);
		}
		
		for (int i = 2; i <= gcd; i++) {
			if (gcd % i == 0) {
				bw.write(i + " ");
			}
		}
		bw.close();
	}
	
	private static int getGcd(int a, int b) {
		while (b > 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

}
