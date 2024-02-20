package 그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_1398 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = { 1, 10, 25 };
		int[] dp = new int[100];
		for (int i = 1; i < 100; i++) {
			dp[i] = i;
			for (int j = 0; j < 3; j++) {
				if (i - arr[j] >= 0) {
					dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
				}
			}
		}
		
		for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
			long price = Long.parseLong(br.readLine());
			int answer = 0;
			
			while (price > 0) {
				answer += dp[(int) price % 100];
				price /= 100;
			}
			bw.write(answer + "\n");
		}
	}

}
