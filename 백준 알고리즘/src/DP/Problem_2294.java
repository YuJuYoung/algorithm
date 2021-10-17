package DP;

import java.io.*;
import java.util.*;

public class Problem_2294 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coins = new int[n + 1];
		int[] dp = new int[k + 1];
		
		for (int i = 1; i <= n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(coins);
		
		for (int i = 1; i <= n; i++) {
            if (coins[i] > k) {
                break;
            }
			if (coins[i] == coins[i - 1]) {
				continue;
			}
            
			for (int j = coins[i]; j <= k; j++) {
				int count = dp[j - coins[i]] + 1;
				
				if (dp[j] == 0) {
					dp[j] = count;
				} else {
					dp[j] = Math.min(dp[j], count);
				}
			}
		}
		System.out.println(dp[k] == 0 ? -1 : dp[k]);
	}

}