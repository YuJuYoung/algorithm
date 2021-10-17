package ±×¸®µð;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1041 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Integer.parseInt(br.readLine());
		int[] dice = new int[6];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		long sum = 0;
		if (N == 1) {
			int max = 0;
			for (int i = 0; i < 6; i++) {
				sum += dice[i];
				max = Math.max(dice[i], max);
			}
			sum -= max;
		} else if (N == 2){
			sum += minOfThree(dice) * 4 + minOfTwo(dice) * 4;
		} else {
			sum += minOfOne(dice) * (5 * N * N - 16 * N + 12);
			sum += minOfTwo(dice) * (8 * N - 12);
			sum += minOfThree(dice) * 4;
		}
		System.out.println(sum);
	}
	
	private static int minOfOne(int[] dice) {
		int min = dice[0];
		for (int i = 1; i < 6; i++) {
			min = Math.min(min, dice[i]);
		}
		return min;
	}
	
	private static int minOfTwo(int[] dice) {
		int min = 100;
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 6; j++) {
				if (i + j == 5) {
					continue;
				}
				min = Math.min(min, dice[i] + dice[j]);
			}
		}
		return min;
	}
	
	private static int minOfThree(int[] dice) {
		int min = 150;
		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (i + j == 5) {
					continue;
				}
				for (int k = j + 1; k < 6; k++) {
					if (i + k == 5 || j + k == 5) {
						continue;
					}
					min = Math.min(min, dice[i] + dice[j] + dice[k]);
				}
			}
		}
		return min;
	}

}
