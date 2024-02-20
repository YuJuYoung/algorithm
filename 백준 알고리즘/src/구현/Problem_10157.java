package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_10157 {
	
	private static int R, C;
	private static long K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		K = Long.parseLong(br.readLine());
		
		if (C * R < K) {
			System.out.println(0);
		} else {
			System.out.println(solve());
		}
	}
	
	private static String solve() {
		int x = 1, y = 0;
		long k = 0;
		
		while (k < K) {
			if (k + R >= K) {
				return x + " " + (y + K - k);
			}
			if ((k += R) == K) {
				break;
			}
			y += R;
			R--;
			C--;
			
			if (k + C >= K) {
				return (x + K - k) + " " + y;
			}
			if ((k += C) == K) {
				break;
			}
			x += C;
			
			if (k + R >= K) {
				return x + " " + (y - K + k);
			}
			if ((k += R) == K) {
				break;
			}
			y -= R;
			R--;
			C--;
			
			if (k + C >= K) {
				return (x - K + k) + " " + y;
			}
			if ((k += C) == K) {
				break;
			}
			x -= C;
		}
		return "0";
	}

}
