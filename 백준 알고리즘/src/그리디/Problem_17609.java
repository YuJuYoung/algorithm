package ±×¸®µð;

import java.io.*;

public class Problem_17609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
			String str = br.readLine();
			
			int count = 0;
			for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
				if (str.charAt(i) == str.charAt(j)) {
					continue;
				}
				if (check(str, i, j - 1) || check(str, i + 1, j)) {
					count = 1;
				} else {
					count = 2;
				}
			    break;
			}
			bw.write(count + "\n");
		}
		bw.close();
	}
	
	private static boolean check(String str, int i, int j) {
		while (j < i) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}
