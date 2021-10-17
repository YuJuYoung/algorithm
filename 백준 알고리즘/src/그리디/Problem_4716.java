package ±×¸®µð;

import java.io.*;
import java.util.*;

public class Problem_4716 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			if (N == 0) {
				break;
			}
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			List<Balloon> toA = new ArrayList<>();
			List<Balloon> toB = new ArrayList<>();
			int answer = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int K = Integer.parseInt(st.nextToken());
				int DA = Integer.parseInt(st.nextToken());
				int DB = Integer.parseInt(st.nextToken());
				
				if (DA == DB) {
					answer += K * DA;
				} else if (DA > DB) {
					toB.add(new Balloon(K, DA, DB));
				} else {
					toA.add(new Balloon(K, DA, DB));
				}
			}
			Collections.sort(toA);
			Collections.sort(toB);
			
			for (int i = 0; i < toA.size(); i++) {
				Balloon temp = toA.get(i);
				int K = temp.K;
				int DA = temp.DA;
				int DB = temp.DB;
				
				if (A == 0) {
					answer += K * DB;
				} else if (K > A) {
					answer += A * DA;
					K -= A;
					A = 0;
					answer += K * DB;
				} else {
					answer += K * DA;
					A -= K;
				}
			}
			for (int i = 0; i < toB.size(); i++) {
				Balloon temp = toB.get(i);
				int K = temp.K;
				int DA = temp.DA;
				int DB = temp.DB;
				
				if (B == 0) {
					answer += K * DA;
				} else if (K > B) {
					answer += B * DB;
					K -= B;
					B = 0;
					answer += K * DA;
				} else {
					answer += K * DB;
					B -= K;
				}
			}
			bw.write(answer + "\n");
		}
		bw.close();
	}
	
	private static class Balloon implements Comparable<Balloon> {
		int K, DA, DB;
		
		public Balloon(int K, int DA, int DB) {
			this.K = K;
			this.DA = DA;
			this.DB = DB;
		}
		
		@Override
		public int compareTo(Balloon o) {
			return Integer.compare(Math.abs(o.DA - o.DB), Math.abs(DA - DB));
		}
	}

}
