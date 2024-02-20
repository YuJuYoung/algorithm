package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_2569 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] answer = new int[n];
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			answer[i] = arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(answer);
		
		int count = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (answer[i] != arr[i]) {
				for (int j = 0; j < i; j++) {
					if (arr[j] == answer[i]) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						count += arr[i] + arr[j];
						System.out.println(arr[i] + " " + arr[j]);
						break;
					}
				}
			}
		}
		System.out.println(count);
	}

}
