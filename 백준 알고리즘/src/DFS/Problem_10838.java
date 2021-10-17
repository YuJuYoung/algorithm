package DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem_10838 {
	
	private static int[] parents;
	private static int[][] colors;
	private static Child[] children;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		parents = new int[N];
		colors = new int[N][N];
		children = new Child[N];
		children[0] = new Child();
		
		for (int i = 1; i < N; i++) {
			children[i] = new Child();
			children[0].add(i);
		}
		
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			String order = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (order.equals("1")) {
				int c = Integer.parseInt(st.nextToken());
				
				paintP(a, b, c);
			} else if (order.equals("2")) {
				int p = parents[a];
				
				colors[a][b] = colors[b][a] = colors[a][p];
				parents[a] = b;
				children[b].add(a);
				children[p].remove(a);
			} else {
				bw.write(countP(a, b, new HashSet<Integer>()).size() + "\n");
			}
		}
		bw.close();
	}
	
	private static void paintP(int a, int b, int c) {
		if (!paintC(a, b, c)) {
			paintP(parents[a], b, c);
			colors[a][parents[a]] = colors[parents[a]][a] = c;
		}
	}
	
	private static boolean paintC(int a, int b, int c) {
		if (a == b) {
			return true;
		}
		for (int child : children[a].list()) {
			if (paintC(child, b, c)) {
				colors[a][child] = colors[child][a] = c;
				return true;
			}
		}
		return false;
	}
	
	private static Set<Integer> countP(int a, int b, Set<Integer> hs) {
		if (!countC(a, b, hs)) {
			countP(parents[a], b, hs);
			hs.add(colors[a][parents[a]]);
		}
		return hs;
	}
	
	private static boolean countC(int a, int b, Set<Integer> hs) {
		if (a == b) {
			return true;
		}
		for (int child : children[a].list()) {
			if (countC(child, b, hs)) {
				hs.add(colors[a][child]);
				return true;
			}
		}
		return false;
	}
	
	private static class Child {
		Set<Integer> hs;
		
		public Child() {
			hs = new HashSet<>();
		}
		
		public void add(int n) {
			hs.add(n);
		}
		
		public void remove(int n) {
			hs.remove(n);
		}
		
		public Set<Integer> list() {
			return hs;
		}
	}

}
