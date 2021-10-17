package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2233 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken()) - 1;
		int Y = Integer.parseInt(st.nextToken()) - 1;
		
		int[] par = new int[N + 1];
		int[][] edge = new int[N + 1][2];
		int last = 0, cur = 1, n = 1;
		int xe = 0, ye = 0;
		
		for (int i = 0; i < str.length(); i++) {
			int tmp = 0;
			
			if (str.charAt(i) == '0') {
				edge[n][0] = i + 1;
				par[n] = last;
				last = tmp = n;
				cur = ++n;
			} else {
				edge[cur][1] = i + 1;
				last = par[cur];
				tmp = cur;
			}
			
			if (X == i) {
				xe = tmp;
			}
			if (Y == i) {
				ye = tmp;
			}
		}
		
		boolean[] visited = new boolean[N + 1];
		cur = xe;
		while (cur != 0) {
			visited[cur] = true;
			cur = par[cur];
		}
		
		cur = ye;
		while (cur != 0) {
			if (visited[cur]) {
				System.out.println(edge[cur][0] + " " + edge[cur][1]);
				return;
			}
			cur = par[cur];
		}
		System.out.println("Èå¿¡!");
	}

}
