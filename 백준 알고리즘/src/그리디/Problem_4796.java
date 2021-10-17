package ±×¸®µð;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_4796 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = 1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			long L = Integer.parseInt(st.nextToken());
			if (L == 0) {
				break;
			}
			long P = Integer.parseInt(st.nextToken());
			long V = Integer.parseInt(st.nextToken());
			
			bw.write(String.format("Case %d: %d\n", count++, V / P * L + (V % P > L ? L : V % P)));
		}
		bw.close();
	}

}
