package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1213 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(getAnswer(getCounts(br.readLine())));
	}
	
	private static int[] getCounts(String str) {
		int[] counts = new int[26];
		
		for (char ch : str.toCharArray()) {
			counts[ch - 'A']++;
		}
		return counts;
	}
	
	private static String getAnswer(int[] counts) {
		StringBuilder sb = new StringBuilder();
		char oddChar = '\u0000';
		
		for (int i = 0; i < 26; i++) {
			int count = counts[i];
			
			if (count == 0) {
				continue;
			}
			char ch = (char) (i + 'A');
			
			if (count % 2 != 0) {
				if (oddChar == '\u0000') {
					oddChar = ch;
				} else {
					return "I'm Sorry Hansoo";
				}
			}
			
			for (int j = 0; j < count / 2; j++) {
				sb.append(ch);
			}
		}
		
		StringBuilder answer = new StringBuilder(sb.toString());
		StringBuilder reverse = sb.reverse();
		
		if (oddChar != '\u0000') {
			answer.append(oddChar);
		}
		
		return answer.append(reverse).toString();
	}

}
