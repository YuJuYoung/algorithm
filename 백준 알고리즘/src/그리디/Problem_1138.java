package 그리디;

import java.io.*;
import java.util.*;

public class Problem_1138 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> list = new ArrayList<>();
		while (N > 0) {
			list.add(arr[N - 1], N--);
		}
		for (int num : list) {
			bw.write(num + " ");
		}
		bw.close();
	}

}
