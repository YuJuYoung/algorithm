package Ω∫≈√;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Problem_6549 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			String[] arr = br.readLine().split(" ");
			
			if (arr[0].equals("0")) {
				break;
			}
			bw.write(Math.max(orderMax(arr), reverseMax(arr)) + "\n");
		}
		bw.close();
	}
	
	private static long orderMax(String[] arr) {
		Stack<int[]> stack = new Stack<>();
		long max = 0;
		
		for (String str : arr) {
			max = Math.max(max, getArea(stack, Integer.parseInt(str)));
		}
		return max;
	}
	
	private static long reverseMax(String[] arr) {
		Stack<int[]> stack = new Stack<>();
		long max = 0;
		
		for (int i = arr.length - 1; i > -1; i--) {
			max = Math.max(max, getArea(stack, Integer.parseInt(arr[i])));
		}
		return max;
	}
	
	private static long getArea(Stack<int[]> stack, int num) {
		int width = 1;;
		
		if (stack.isEmpty() || stack.peek()[0] < num) {
			stack.push(new int[] { num, 1 });
		} else {
			while (!stack.isEmpty() && stack.peek()[0] >= num) {
				width += stack.pop()[1];
			}
			stack.push(new int[] { num, width });
		}
		return (long) num * width;
	}

}
