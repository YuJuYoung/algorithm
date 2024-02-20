package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_3054 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int len = str.length();
		
		StringBuilder top_bottom = top_bottom(len);
		StringBuilder between = between(len);
		StringBuilder mid = mid(str);
		
		StringBuilder answer = new StringBuilder();
		
		answer.append(top_bottom);
		answer.append(between);
		answer.append(mid);
		answer.append(between);
		answer.append(top_bottom);
		
		System.out.print(answer);
	}
	
	private static StringBuilder top_bottom(int len) {
		StringBuilder sb = new StringBuilder(".");
		
		for (int i = 1; i <= len; i++) {
			if (i % 3 == 0) {
				sb.append(".*..");
			} else {
				sb.append(".#..");
			}
		}
		return sb.append("\n");
	}
	
	private static StringBuilder between(int len) {
		StringBuilder sb = new StringBuilder(".");
		
		for (int i = 1; i <= len; i++) {
			if (i % 3 == 0) {
				sb.append("*.*.");
			} else {
				sb.append("#.#.");
			}
		}
		return sb.append("\n");
	}
	
	private static StringBuilder mid(String str) {
		StringBuilder sb = new StringBuilder("#");
		
		for (int i = 0; i < str.length(); i++) {
			sb.append(".");
			sb.append(str.charAt(i));
			
			if ((i + 1) % 3 == 0) {
				sb.append(".*");
			} else {
				if (i + 1 < str.length() && (i + 2) % 3 == 0) {
					sb.append(".*");
				} else {
					sb.append(".#");
				}
			}
		}
		return sb.append("\n");
	}

}
