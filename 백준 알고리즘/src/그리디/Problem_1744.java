package ±×¸®µð;

import java.io.*;
import java.util.*;

public class Problem_1744 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> plus = new ArrayList<>();
		List<Integer> minus = new ArrayList<>();
		
		int sum = 0;
		boolean hasZero = false;
		for (int N = Integer.parseInt(br.readLine()); N > 0; N--) {
			int number = Integer.parseInt(br.readLine());
			if (number == 1) {
				sum++;
			} else if (number == 0) {
				hasZero = true;
			} else if (number > 1) {
				plus.add(number);
			} else {
				minus.add(number);
			}
		}
		if (plus.size() % 2 == 1) {
			plus.add(1);
		}
		if (minus.size() % 2 == 1) {
			minus.add(hasZero ? 0 : 1);
		}
		Collections.sort(plus);
		Collections.sort(minus);
		bw.write((sum += calPlus(plus) + calMinus(minus)) + "\n");
		bw.close();
	}
	
	private static int calPlus(List<Integer> plus) {
		int sum = 0;
		for (int i = 0; i < plus.size() - 1; i += 2) {
			sum += plus.get(i) * plus.get(i + 1);
		}
		return sum;
	}
	
	private static int calMinus(List<Integer> minus) {
		int sum = 0;
		for (int i = 0; i < minus.size() - 1; i += 2) {
			sum += minus.get(i) * minus.get(i + 1);
		}
		return sum;
	}

}
