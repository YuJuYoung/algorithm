package ¼öÇĞ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2004 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int o = n - m;
		
		int fc = five(n) - five(m) - five(o);
		int tc = two(n) - two(m) - two(o);
		
		System.out.println(Math.min(fc, tc));
	}
	
	private static int five(int n) {
		int count = 0;
		
		while (n > 4) {
			count += n / 5;
			n /= 5;
		}
		return count;
	}
	
	private static int two(int n) {
		int count = 0;
		
		while (n > 1) {
			count += n / 2;
			n /= 2;
		}
		return count;
	}

}
