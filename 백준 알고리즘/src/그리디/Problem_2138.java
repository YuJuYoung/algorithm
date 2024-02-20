package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2138 {
	
	private static String before, after;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		before = br.readLine();
		after = br.readLine();
		
		int answer = Math.min(solve(true, before, N), solve(false, before, N));
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	
	private static int solve(boolean zero, String before, int N) {
		char[] chars = before.toCharArray();
		int count = 1;
		
		if (zero) {
			chars[0] = change(chars[0]);
			count++;
		}
		
		for (int i = 1; i < N; i++) {
			if (chars[i - 1] == after.charAt(i - 1)) {
				continue;
			}
			chars[i - 1] = change(chars[i - 1]);
			chars[i] = change(chars[i]);
			count++;
		}
		if (chars[N - 1] != after.charAt(N - 1)) {
			return Integer.MAX_VALUE;
		}
		return count;
	}
	
	private static char change(char c) {
		return c == '0' ? '1' : '0';
	}

}
