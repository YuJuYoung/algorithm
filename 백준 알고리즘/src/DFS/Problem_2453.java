package DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_2453 {
	
	private static Node[] tree;
	private static int[] group;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			tree = new Node[N + 1];
			group = new int[N + 1];
			
			List<int[]> cp = new ArrayList<>();
			while (M-- > 0) {
				st = new StringTokenizer(br.readLine());
				
				String tmp = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if (tmp.equals("-1")) {
					cp.add(new int[] { x, y });
				} else {
					tree[x] = new Node(y, tree[x]);
					tree[y] = new Node(x, tree[y]);
				}
			}
			
			int groupNum = 1;
		}
		bw.close();
	}
	
	private static class Node {
		int n;
		Node next;
		
		public Node(int n, Node next) {
			this.n = n;
			this.next = next;
		}
	}

}
