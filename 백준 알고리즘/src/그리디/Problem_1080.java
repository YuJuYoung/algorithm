package ±×¸®µð;

import java.io.*;
import java.util.StringTokenizer;

public class Problem_1080 {
	private static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] A = new int[N][M];
		int[][] B = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				A[i][j] = str.charAt(j) - 48;
			}
		}
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				B[i][j] = str.charAt(j) - 48;
			}
		}
		for (int i = 0; i <= N - 3; i++) {
			for (int j = 0; j <= M - 3; j++) {
				if (A[i][j] != B[i][j]) {
					A = change(A, i, j);
					count++;
				}
			}
		}
		bw.write((!check(A, B, N, M) ? -1 : count) + "\n");
		bw.close();
	}
	
	private static boolean check(int[][] A, int[][] B, int N, int M) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static int[][] change(int[][] A, int i, int j) {
		for (int k = i; k < i + 3; k++) {
			for (int l = j; l < j + 3; l++) {
				if (A[k][l] == 1) {
					A[k][l] = 0;
				} else {
					A[k][l] = 1;
				}
			}
		}
		return A;
	}

}
