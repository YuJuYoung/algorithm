package ±¸Çö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_14891 {
	
	private static int[] gear = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < 8; j++) {
				if (str.charAt(j) == '1') {
					gear[i] += Math.pow(2, 7 - j);
				}
			}
		}
		
		for (int K = Integer.parseInt(br.readLine()); K > 0; K--) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int idx = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			
			int[][] arr = { { left(0), right(0) }, { left(1), right(1) },
					{ left(2), right(2) }, { left(3), right(3) } };
			turnGear(idx, d);
			
			if (idx == 0) {
				for (int i = 1; i < 4; i++) {
					if (arr[i - 1][1] == arr[i][0]) {
						break;
					}
					turnGear(i, d = changeD(d));
				}
			} else if (idx == 1) {
				d = changeD(d);
				
				if (arr[0][1] != arr[1][0]) {
					turnGear(0, d);
				}
				if (arr[1][1] != arr[2][0]) {
					turnGear(2, d);
					
					if (arr[2][1] != arr[3][0]) {
						turnGear(3, changeD(d));
					}
				}
			} else if (idx == 2) {
				d = changeD(d);
				
				if (arr[3][0] != arr[2][1]) {
					turnGear(3, d);
				}
				if (arr[2][0] != arr[1][1]) {
					turnGear(1, d);
					
					if (arr[1][0] != arr[0][1]) {
						turnGear(0, changeD(d));
					}
				}
			} else {
				for (int i = 2; i >= 0; i--) {
					if (arr[i][1] == arr[i + 1][0]) {
						break;
					}
					turnGear(i, d = changeD(d));
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += (gear[i] >> 7) * (1 << i);
		}
		System.out.println(sum);
	}
	
	private static int left(int idx) {
		return (gear[idx] >> 1) % 2;
	}
	
	private static int right(int idx) {
		return (gear[idx] >> 5) % 2;
	}
	
	private static void turnGear(int idx, int d) {
		if (d == 1) {
			if (gear[idx] % 2 == 1) {
				gear[idx] += 1 << 8;
			}
			gear[idx] = gear[idx] >> 1;
		} else {
			int tmp = 0;
			
			if (gear[idx] >> 7 == 1) {
				tmp = 1;
			}
			gear[idx] = (gear[idx] << 1) % 256 + tmp;
		}
	}
	
	private static int changeD(int d) {
		return d == 1 ? -1 : 1;
	}

}
