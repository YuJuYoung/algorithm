package ±×¸®µð;

import java.io.*;
import java.util.Arrays;

public class Problem_1339 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] chars = new int[10];
		int[] nums = new int[10];
		
		for (int N = Integer.parseInt(br.readLine()); N > 0; N--) {
			String str = br.readLine();
			int len = str.length();
			int ten = (int) Math.pow(10, len - 1);
			for (int i = 0; i < len; i++, ten /= 10) {
				char ch = str.charAt(i);
				
				for (int j = 0; j < 10; j++) {
					if (chars[j] == 0) {
						chars[j] = ch;
						nums[j] += ten;
						break;
					}
					if (chars[j] == ch) {
						nums[j] += ten;
						break;
					}
				}
			}
		}
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 9; i > 0; i--) {
			sum += nums[i] * i;
		}
		System.out.println(sum);
	}

}
