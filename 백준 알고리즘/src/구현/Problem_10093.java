package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_10093 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		if (A == B) {
			System.out.println(0);
		} else {
			if (A > B) {
				long tmp = A;
				A = B;
				B = tmp;
			}
			StringBuilder sb = new StringBuilder();
			int count = 0;
			
			while (++A < B) {
				sb.append(A).append(' ');
				count++;
			}
			System.out.println(count + "\n" + sb);
		}
	}

}
