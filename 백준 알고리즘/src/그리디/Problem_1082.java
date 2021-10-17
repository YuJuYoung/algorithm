package ±×¸®µð;

import java.io.*;
import java.util.*;

public class Problem_1082 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int min = 51, num = 10;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if (min > arr[i]) {
				min = arr[i];
				num = i;
			}
		}
		int money = Integer.parseInt(br.readLine());
		
		if (N == 1) {
			System.out.println(0);
			return;
		}
		int len = money / min;
		money %= min;
		
		StringBuilder sb = new StringBuilder();
		int last = N - 1;
		while (len-- > 0) {
			boolean flag = false;
			
			for (int i = last; i > num; i--) {
				if (money + min >= arr[i]) {
					money -= arr[i] - min;
					last = i;
					flag = true;
					sb.append(i);
					break;
				}
			}
			if (sb.length() == 0 && num == 0) {
				money += min;
			} else {
				if (!flag) {
					sb.append(num);
				}
			}
		}
		System.out.println(sb.length() == 0 ? 0 : sb);
	}

}