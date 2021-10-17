package ±×¸®µð;

import java.io.*;
import java.util.*;

public class Problem_1700 {
	private static int idx = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];
		int[] count = new int[K + 1];
		int[][] index = new int[K + 1][K + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			index[num][++count[num]] = i;
		}
		
		int answer = 0;
		int[] temp = new int[N];
		for (int i = 0; i < K; i++) {
			int num = arr[i];
			if (idx == 0) {
				temp[idx++] = num;
			} else {
				if (!contains(temp, num)) {
					if (idx < N) {
						temp[idx++] = num;
					} else {
						int max = -1;
						int found = -1;
						for (int j = 0; j < N; j++) {
							if (count[temp[j]] == 0) {
								found = j;
								break;
							}
							if (max < index[temp[j]][index[temp[j]][0] + 1]) {
								max = index[temp[j]][index[temp[j]][0] + 1];
								found = j;
							}
						}
						temp[found] = num;
						answer++;
					}
				}
			}
			count[num]--;
			index[num][0]++;
		}
		bw.write(answer + "\n");
		bw.close();
	}
	
	private static boolean contains(int[] temp, int num) {
		for (int n : temp) {
			if (num == n) {
				return true;
			}
		}
		return false;
	}

}
