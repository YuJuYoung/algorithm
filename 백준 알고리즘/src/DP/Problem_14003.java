package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_14003 {
	
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] P = new int[N];
		dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr[0] = dp[0] = Integer.parseInt(st.nextToken());
		
		int len = 0;
		for (int i = 1; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			int index = dp[len] < arr[i] ? ++len : binarySearch(0, len, arr[i]);
			dp[index] = arr[i];
			P[i] = index;
		}
		bw.write((len + 1) + "\n");
		
		int[] answer = new int[len + 1];
		for (int i = N - 1; i >= 0 ; i--) {
			if (P[i] == len) {
				answer[len--] = arr[i];
				
				if (len < 0) {
					break;
				}
			}
		}
		for (int num : answer) {
			bw.write(num + " ");
		}
		bw.close();
	}
	
	private static int binarySearch(int s, int e, int num) {
		while (s < e) {
			int mid = (s + e) / 2;
			
			if (dp[mid] < num) {
				s = mid + 1;
			} else {
				e = mid;
			}
		}
		return e;
	}

}
