package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1201 {
	private static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if (M + K - 1 > N || M * K < N) {
			System.out.println(-1);
			return;
		}
		append(1, K);
		
		if (--M != 0) {
			int L = (N - K) / M;
		    int R = (N - K) % M;
		
		    for (int i = K + 1; i <= N; i += L) {
			    if (R > 0) {
				    append(i, i++ + L);
				    R--;
			    } else {
				    append(i, i + L - 1);
			    }
		    }
		}
		System.out.println(answer);
	}
	
	private static void append(int start, int end) {
		for (int i = end; i >= start; i--) {
			answer.append(i).append(" ");
		}
	}

}
