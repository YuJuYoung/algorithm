package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_16432 {
	
	private static int N;
	private static Node[] arr;
	
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new Node[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			arr[i] = new Node();
			for (int j = Integer.parseInt(st.nextToken()); j > 0; j--) {
				int n = Integer.parseInt(st.nextToken());
				
				if (i > 0 && arr[i - 1].list.size() == 1) {
					if (arr[i - 1].list.get(0) == n) {
						continue;
					}
				}
				arr[i].list.add(n);
			}
			
			if (arr[i].list.size() == 0) {
				System.out.println(-1);
				return;
			}
		}
		
		dfs(N - 1, -1);
		System.out.print(sb.reverse());
	}
	
	private static void dfs(int n, int last) {
		if (n == 0) {
			for (int tmp : arr[0].list) {
				if (tmp != last) {
					sb.append('\n').append(tmp);
					break;
				}
			}
			return;
		}
		
		for (int tmp : arr[n].list) {
			if (tmp != last) {
				sb.append('\n').append(tmp);
				dfs(n - 1, tmp);
				break;
			}
		}
	}
	
	private static class Node {
		List<Integer> list;
		
		public Node() {
			list = new ArrayList<>();
		}
	}

}
