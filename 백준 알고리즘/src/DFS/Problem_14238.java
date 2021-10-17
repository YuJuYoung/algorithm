package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_14238 {
	
	private static char[] chars;
	private static boolean[][][][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		chars = new char[s.length()];
		
		int a = 0, b = 0, c = 0;
		
		for (char ch : s.toCharArray()) {
			if (ch == 'A') {
				a++;
			} else if (ch == 'B') {
				b++;
			} else {
				c++;
			}
		}
		visited = new boolean[a + 1][b + 1][c + 1][3][3];
		
		if (!dfs(a, b, c, 0)) {
			System.out.println(-1);
		} else {
			StringBuilder sb = new StringBuilder();
			
			for (char ch : chars) {
				sb.append(ch);
			}
			System.out.println(sb);
		}
	}
	
	private static boolean dfs(int a, int b, int c, int idx) {
		if (idx == chars.length) {
			return true;
		}
		if (idx > 1) {
			int n1 = chars[idx - 2] - 'A';
			int n2 = chars[idx - 1] - 'A';
			
			if (visited[a][b][c][n1][n2]) {
				return false;
			}
			visited[a][b][c][n1][n2] = true;
		}
		
		if (a > 0) {
			chars[idx] = 'A';
			
			if (dfs(a - 1, b, c, idx + 1)) {
				return true;
			}
		}
		if (b > 0) {
			if (idx == 0 || chars[idx - 1] != 'B') {
				chars[idx] = 'B';
				
				if (dfs(a, b - 1, c, idx + 1)) {
					return true;
				}
			}
		}
		if (c > 0) {
			if (idx > 0 && chars[idx - 1] == 'C') {
				return false;
			}
			if (idx > 1 && chars[idx - 2] == 'C') {
				return false;
			}
			chars[idx] = 'C';
			
			if (dfs(a, b, c - 1, idx + 1)) {
				return true;
			}
		}
		return false;
	}

}
