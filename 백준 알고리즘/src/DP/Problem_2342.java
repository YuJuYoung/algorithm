package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2342 {
	
	private static int[] seq;
	private static int seqLen, ans;

	public static void main(String[] args) throws IOException {
		setVar();
		solve();
		printAns();
	}
	
	private static void setVar() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		seqLen = str.length() / 2;
		
		if (seqLen == 0) {
			return;
		}
		seq = new int[seqLen];
		
		for (int i = 0; i < seq.length; i++) {
			seq[i] = str.charAt(i * 2) - 48;
		}
	}
	
	private static void solve() {
		if (seq == null) {
			ans = 0;
		} else {
			int[][][] dp = new int[seqLen][5][5];
		}
	}
	
	private static void printAns() {
		System.out.println(ans);
	}

}
