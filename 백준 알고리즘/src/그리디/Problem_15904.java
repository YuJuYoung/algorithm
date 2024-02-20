package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_15904 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String ucpc = "UCPC";
		int index = 0;
		
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ucpc.charAt(index)) {
				if (++index == 4) {
					System.out.println("I love UCPC");
					return;
				}
			}
		}
		System.out.println("I hate UCPC");
	}

}
