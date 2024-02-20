package 그리디;

import java.io.*;
import java.util.*;

public class Problem_2437 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] sequence = new int[N];
		for (int i = 0; i < N; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sequence);
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (sequence[i] >= sum + 2) {
				break;
			}
			sum += sequence[i];
		}
		bw.write((sum + 1) + "\n");
		bw.close();
	}

}
