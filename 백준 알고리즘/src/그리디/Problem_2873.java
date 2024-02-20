package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2873 {
	private static String leftRight = "R", upDown = "D";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] site = new int[R][C];
		
		int minX = -1, minY = -1, min = 1000;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				site[i][j] = Integer.parseInt(st.nextToken());
				
				if ((i + j) % 2 == 1 && site[i][j] < min) {
					min = site[i][j];
					minX = j;
					minY = i;
				}
			}
		}
		
		StringBuilder answer = new StringBuilder();
		
		if (R % 2 == 1) {
			for (int i = 0; i < R; i++) {
				for (int j = 1; j < C; j++) {
					answer.append(leftRight);
				}
				answer.append(upDown);
				changeleftRight();
			}
		} else if (C % 2 == 1) {
			for (int i = 0; i < C; i++) {
				for (int j = 1; j < R; j++) {
					answer.append(upDown);
				}
				answer.append(leftRight);
				changeUpDown();
			}
		} else {
			int i = 0;
			for (; i + 1 < minY; i += 2) {
				for (int j = 0; j < 2; j++) {
					for (int k = 1; k < C; k++) {
						answer.append(leftRight);
					}
					answer.append(upDown);
					changeleftRight();
				}
			}
			for (int j = 0; j < C; j++) {
				if (j == minX) {
					if (j == C - 1) {
						answer.append("D");
						break;
					} else {
						answer.append(leftRight);
						continue;
					}
				}
				answer.append(upDown);
				if (j == C - 1) {
					answer.append("D");
				} else {
					answer.append(leftRight);
				}
				changeUpDown();
			}
			
			leftRight = "L";
			upDown = "D";
			for (i += 2; i < R; i++) {
				for (int j = 1; j < C; j++) {
					answer.append(leftRight);
				}
				answer.append(upDown);
				changeleftRight();
			}
		}
		System.out.println(answer.deleteCharAt(answer.length() - 1));
	}
	
	private static void changeUpDown() {
		upDown = upDown == "U" ? "D" : "U";
	}
	
	private static void changeleftRight() {
		leftRight = leftRight == "R" ? "L" : "R";
	}

}
