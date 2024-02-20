package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_3613 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(solve(br.readLine()));
	}
	
	private static String solve(String input) {
		char tmp = input.charAt(0);
		
		if (tmp == '_' || (tmp >= 'A' && tmp <= 'Z')) {
			return "Error!";
		}
		StringBuilder sb = new StringBuilder().append(tmp);
		
		boolean toJava = false;
		boolean upper = false;
		
		boolean toCpp = false;
		
		for (int i = 1; i < input.length(); i++) {
			char c = input.charAt(i);
			
			if (c >= 'a' && c <= 'z') {
				if (upper) {
					sb.append((char) (c - 32));
					upper = false;
				} else {
					sb.append(c);
				}
			} else {
				if (c == '_') {
					if (toCpp || upper) {
						return "Error!";
					}
					toJava = upper = true;
				} else if (c >= 'A' && c <= 'Z') {
					if (toJava) {
						return "Error!";
					} else {
						sb.append('_').append((char) (c + 32));
					}
					toCpp = true;
				} else {
					return "Error!";
				}
			}
		}
		return upper ? "Error!" : sb.toString();
	}

}
