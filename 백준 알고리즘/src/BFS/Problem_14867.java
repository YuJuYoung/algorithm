package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem_14867 {
	
	private static Queue<Pair> q = new LinkedList<>();
	private static Set<Pair> hs = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		add(new Pair(0, 0));
		System.out.println(bfs(a, b, c, d));
	}
	
	private static int bfs(int a, int b, int c, int d) {
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				Pair p = q.poll();
				if (p.a == c && p.b == d) {
					return time;
				}
				
				add(new Pair(p.a, b));
				add(new Pair(a, p.b));
				add(new Pair(p.a, 0));
				add(new Pair(0, p.b));
				
				int tmpA = 0, tmpB = 0;
				
				if (a - p.a >= p.b) {
					tmpA = p.a + p.b;
					tmpB = 0;
				} else {
					tmpA = a;
					tmpB = p.b - a + p.a;
				}
				add(new Pair(tmpA, tmpB));
				
				if (b - p.b >= p.a) {
					tmpB = p.b + p.a;
					tmpA = 0;
				} else {
					tmpB = b;
					tmpA = p.a - b + p.b;
				}
				add(new Pair(tmpA, tmpB));
			}
			time++;
		}
		return -1;
	}
	
	private static void add(Pair p) {
		if (!hs.contains(p)) {
			q.add(p);
			hs.add(p);
		}
	}
	
	private static class Pair {
		int a, b;
		
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public boolean equals(Object o) {
			Pair tmp = (Pair) o;
			return a == tmp.a && b == tmp.b;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(a, b);
		}
	}

}
