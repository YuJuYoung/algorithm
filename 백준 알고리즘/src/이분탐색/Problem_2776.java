package 이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_2776 {
	
	private static int N, M;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < M; i++) {
				if (binarysearch(Integer.parseInt(st.nextToken()))) {
					bw.write("1");
				} else {
					bw.write("0");
				}
				bw.newLine();
			}
		}
		bw.close();
	}
	
	private static boolean binarysearch(int n) {
		int s = 0, e = N - 1;
		
		while (s <= e) {
			int m = (s + e) / 2;
			
			if (arr[m] == n) {
				return true;
			}
			
			if (arr[m] < n) {
				s = m + 1;
			} else {
				e = m - 1;
			}
		}
		return false;
	}

}
