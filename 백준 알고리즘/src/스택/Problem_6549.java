package Ω∫≈√;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
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
			bw.write(solve() + "\n");
		}
		bw.close();
	}
	
	private static long solve() {
		Stack<int[]> stack = new Stack<>();
		long max = 0;
		
		for (int i = 0; i < n; i++) {
			int num = arr[i];
			
			if (stack.isEmpty()) {
				stack.push(new int[] { num, i });
			} else {
				if (stack.peek()[0] == num) {
					continue;
				}
				int idx = i;
				
				while (!stack.isEmpty()) {
					if (stack.peek()[0] < num) {
						break;
					}
					int[] node = stack.pop();
					
					idx = node[1];
					max = Math.max(max, (long) node[0] * (i - idx));
				}
				stack.push(new int[] { num, idx });
			}
		}
		
		while (!stack.isEmpty()) {
			int[] node = stack.pop();
			
			long num = node[0];
			int idx = node[1];
			
			max = Math.max(max, num * (n - idx));
		}
		return max;
	}

}
