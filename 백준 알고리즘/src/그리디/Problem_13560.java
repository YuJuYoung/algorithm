package ±×¸®µð;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_13560 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(arr);
		
		int point = 0;
		for (int i = n - 1; i >= 0; i--) {
			int d = arr[i] - i;
			
			if (d > 0) {
				if (point < d) {
					System.out.println(-1);
					return;
				}
				point -= d;
			} else {
				point += -d;
			}
		}
		System.out.println(point != 0 ? -1 : 1);
	}

}
