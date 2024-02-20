package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1212 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String ans = toBinaryString(br.readLine());
		System.out.println(ans);
	}
	
	private static String toBinaryString(String str) {
		if (str.equals("0")) {
			return "0";
		}
		int[] arr = { 4, 2, 1 };
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			int n = str.charAt(i) - 48;
			
			for (int tmp : arr) {
				if (n >= tmp) {
					sb.append(1);
					n -= tmp;
				} else {
					sb.append(0);
				}
			}
		}
		
		while (sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

}
