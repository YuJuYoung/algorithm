package ±¸Çö;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_11723 {
	
	private static int S = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int M = Integer.parseInt(br.readLine()); M > 0; M--) {
			String str = br.readLine();
			
			if (str.equals("all")) {
				S = (1 << 20) - 1;
			} else if (str.equals("empty")) {
				S = 0;
			} else {
				String[] arr = str.split(" ");
				
				String cmd = arr[0];
				int xBit = 1 << (Integer.parseInt(arr[1]) - 1);
				
				if (cmd.equals("add")) {
					S |= xBit;
				} else if (cmd.equals("remove")) {
					S &= ~xBit;
				} else if (cmd.equals("check")) {
					bw.write((S | xBit) == S ? "1\n" : "0\n");
				} else {
					S ^= xBit;
				}
			}
		}
		bw.close();
	}

}
