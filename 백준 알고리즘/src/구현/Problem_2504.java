package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2504 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ans = solve(br.readLine());
		System.out.println(ans);
	}
	
	private static int solve(String str) {
		if (str.length() % 2 != 0) {
			return 0;
		}
		
		Stack stack = new Stack(str.length() / 2);
		int[] floorValues = new int[str.length() / 2 + 1];
		int depth = 0;
		
		for (int i = 0; i < str.length(); i++) {
			char c1 = str.charAt(i);
			
			if (c1 == '(' || c1 == '[') {
				stack.push(c1);
				depth++;
			} else {
				if (stack.isEmpty()) {
					return 0;
				}
				char c2 = stack.pop();
				
				if (c1 == ')' && c2 == '(') {
					floorValues[depth - 1] += floorValues[depth] == 0 ? 2 : floorValues[depth] * 2;
				} else if (c1 == ']' && c2 == '[') {
					floorValues[depth - 1] += floorValues[depth] == 0 ? 3 : floorValues[depth] * 3;
				} else {
					return 0;
				}
				floorValues[depth--] = 0;
			}
		}
		
		if (!stack.isEmpty()) {
			return 0;
		}
		return floorValues[0];
	}
	
	private static class Stack {
		char[] arr;
		int top = -1;
		
		public Stack(int size) {
			arr = new char[size];
		}
		
		public void push(char data) {
			arr[++top] = data;
		}
		
		public char pop() {
			return arr[top--];
		}
		
		public boolean isEmpty() {
			return top == -1;
		}
	}

}
