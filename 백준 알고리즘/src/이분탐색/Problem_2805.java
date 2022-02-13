package ÀÌºÐÅ½»ö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2805 {
	
	private static int N, M;
	private static int[] trees;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		trees = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, trees[i]);
		}
		System.out.println(binarysearch(0, max));
	}
	
	private static int binarysearch(int s, int e) {
		while (s < e) {
			int mid = (s + e) / 2 + 1;
			
			if (cutTree(mid)) {
				s = mid;
			} else {
				e = mid - 1;
			}
		}
		return e;
	}
	
	private static boolean cutTree(int h) {
		long sum = 0;
		
		for (int i = 0; i < N; i++) {
			if (trees[i] > h) {
				sum += trees[i] - h;
				
				if (sum >= M) {
					return true;
				}
			}
		}
		return false;
	}

}
