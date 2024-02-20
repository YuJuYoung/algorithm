package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1072 {
	
	private static long X, Y, Z;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		Z = getZ(0);
		
		System.out.println(binarysearch());
	}
	
	private static long binarysearch() {
		long s = 1, e = X;
		
		while (s < e) {
			long m = (s + e) / 2;
			
			if (getZ(m) > Z) {
				e = m;
			} else {
				s = m + 1;
			}
		}
		return getZ(s) == Z ? -1 : s;
	}
	
	private static long getZ(long n) {
		return (Y + n) * 100 / (X + n);
	}

}
