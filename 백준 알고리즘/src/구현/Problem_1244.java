package ±¸Çö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1244 {
	
	private static int n;
	private static char[] buttons;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		buttons = new char[n + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			buttons[i] = st.nextToken().charAt(0);
		}
		
		for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
			st = new StringTokenizer(br.readLine());
			action(st.nextToken(), Integer.parseInt(st.nextToken()));
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(buttons[i]).append(' ');
			
			if (i % 20 == 0) {
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}
	
	private static void action(String sex, int num) {
		if (sex.equals("1")) {
			for (int i = num; i <= n; i += num) {
				buttons[i] = buttons[i] == '1' ? '0' : '1';
			}
		} else {
			int l = num, r = num;
			
			while (l >= 1 && r <= n) {
				if (buttons[l] != buttons[r]) {
					break;
				}
				buttons[l] = buttons[r] = buttons[l] == '1' ? '0' : '1';
				l--;
				r++;
			}
		}
	}

}
