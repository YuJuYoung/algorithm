package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_13458 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		int B = Integer.parseInt(st2.nextToken());
		int C = Integer.parseInt(st2.nextToken());
		
		long ans = 0;
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken()) - B;
			
			if (n > 0) {
				ans += (n + C - 1) / C;
			}
		}
		System.out.println(ans + N);
	}

}
