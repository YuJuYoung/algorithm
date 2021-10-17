package BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_9019 {
	
	private static char[] chars = { 'D', 'S', 'L', 'R' };
	private static Node[] answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			answer = new Node[10000];
			bw.write(bfs(A, B) + "\n");
		}
		bw.close();
	}
	
	private static StringBuilder bfs(int A, int B) {
		Queue<Integer> q = new LinkedList<>();
		q.add(A);
		
		while (!q.isEmpty()) {
			int n = q.poll();
			int[] arr = { D(n), S(n), L(n), R(n) };
			
			for (int i = 0; i < 4; i++) {
				int tmp = arr[i];
				
				if (tmp == B) {
					StringBuilder sb = new StringBuilder().append(chars[i]);
					
					while (n != A) {
						sb.append(answer[n].ch);
						n = answer[n].from;
					}
					return sb.reverse();
				}
				if (answer[tmp] == null) {
					answer[tmp] = new Node(n, chars[i]);
					q.add(tmp);
				}
			}
		}
		return null;
	}
	
	private static int D(int n) {
		return 2 * n % 10000;
	}
	
	private static int S(int n) {
		return n == 0 ? 9999 : n - 1;
	}
	
	private static int L(int n) {
		return n / 1000 + n % 1000 * 10;
	}
	
	private static int R(int n) {
		return n % 10 * 1000 + n / 10;
	}
	
	private static class Node {
		int from;
		char ch;
		
		public Node(int from, char ch) {
			this.from = from;
			this.ch = ch;
		}
	}

}
