package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_16120 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int len = str.length(), p = 0;
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == 'P') {
				p++;
			} else {
				if (p >= 2 && (i < len - 1 && str.charAt(i + 1) == 'P')) {
					p--;
					i++;
				} else {
					System.out.println("NP");
					return;
				}
			}
		}
		System.out.println(p != 1 ? "NP" : "PPAP");
	}

}
