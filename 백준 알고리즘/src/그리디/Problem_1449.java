package 그리디;

import java.io.*;
import java.util.*;

public class Problem_1449 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int last = 0, answer = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] > last) {
				last = arr[i] + L - 1;
				answer++;
			}
		}
		System.out.println(answer);
	}

}
