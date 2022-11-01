package ±¸Çö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2477 {
	
	private static String[] inputArr = new String[7];
	private static int K = 0;
	
	private static final int E = 1, W = 2, S = 3, N = 4;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < 6; i++) {
			inputArr[i] = br.readLine();
		}
		inputArr[6] = inputArr[0];
		
		int maxW = 0, maxH = 0;
		int blankArea = 0;
		
		int lastDir = 0;
		int lastLen = 0;
		
		for (String input : inputArr) {
			String[] splitedInput = input.split(" ");
			
			int dir = Integer.parseInt(splitedInput[0]);
			int len = Integer.parseInt(splitedInput[1]);
			
			if (dir == E || dir == W) {
				maxW = Math.max(maxW, len);
			} else {
				maxH = Math.max(maxH, len);
			}
			
			if (blankArea == 0) {
				if (lastDir == 0) {
					lastDir = dir;
					lastLen = len;
				} else {
					if (!isRightOrder(lastDir, dir)) {
						blankArea = lastLen * len;
						continue;
					}
				}
				
				lastDir = dir;
				lastLen = len;
			}
		}
		
		System.out.println((maxW * maxH - blankArea) * K);
	}
	
	// E = 1, W = 2, S = 3, N = 4
	private static boolean isRightOrder(int last, int cur) {
		if (last == W && cur == S) {
			return true;
		}
	    if (last == S && cur == E) {
	    	return true;
	    }
		if (last == E && cur == N) {
			return true;
		}
		if (last == N && cur == W) {
			return true;
		}
		
		return false;
	}

}
