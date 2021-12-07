package ±¸Çö;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem_11723 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] S = new boolean[21];
		
		for (int M = Integer.parseInt(br.readLine()); M > 0; M--) {
			String[] arr = br.readLine().split(" ");
			
			String cmd = arr[0];
			
			if (cmd.equals("all")) {
				Arrays.fill(S, true);
			} else if (cmd.equals("empty")) {
				Arrays.fill(S, false);
			} else {
				int x = Integer.parseInt(arr[1]);
				
				if (cmd.equals("add")) {
					S[x] = true;
				} else if (cmd.equals("remove")) {
					S[x] = false;
				} else if (cmd.equals("check")) {
					bw.write(S[x] ? "1\n" : "0\n");
				} else {
					S[x] = !S[x];
				}
			}
		}
		bw.close();
	}

}
