package Ω∫≈√;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_6549 {
	
	private static int n;
	private static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			if ((n = Integer.parseInt(st.nextToken())) == 0) {
				break;
			}
			arr = new int[n];
			
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			bw.write(divide(0, n - 1) + "\n");
		}
		bw.close();
	}
	
	private static long divide(int l, int r) {
		if (l == r) {
			return arr[l];
		}
		int m = (l + r) / 2;
		
		long leftArea = divide(l, m);
		long rightArea = divide(m + 1, r);
		
		long max = Math.max(leftArea, rightArea);
		long area = getArea(l, r, m);
		
		return Math.max(max, area);
	}
	
	private static long getArea(int l, int r, int m) {
		int toRight = m, toLeft = m;
		long h = arr[m], max = arr[m];
		
		while (l < toLeft || toRight < r) {
			if (toRight == r) {
				h = Math.min(h, arr[--toLeft]);
			} else if (toLeft == l) {
				h = Math.min(h, arr[++toRight]);
			} else {
				if (arr[toLeft - 1] < arr[toRight + 1]) {
					h = Math.min(h, arr[++toRight]);
				} else {
					h = Math.min(h, arr[--toLeft]);
				}
			}
			max = Math.max(max, h * (toRight - toLeft + 1));
		}
		return max;
	}

}
