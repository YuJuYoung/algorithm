package DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_10216 {
	
	private static int N, start;
	private static Point[] arr;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
			N = Integer.parseInt(br.readLine());
			arr = new Point[N];
			visited = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				arr[i] = new Point(x, y, r);
			}
			
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					dfs(start = i);
					count++;
				}
			}
			bw.write(count + "\n");
		}
		bw.close();
	}
	
	private static void dfs(int index) {
		visited[index] = true;
		
		for (int i = start + 1; i < N; i++) {
			if (!visited[i] && isGroup(index, i)) {
				dfs(i);
			}
		}
	}
	
	private static boolean isGroup(int i, int j) {
		int a = arr[i].x - arr[j].x;
		int b = arr[i].y - arr[j].y;
		int c = arr[i].r + arr[j].r;
		
		return a * a + b * b <= c * c;
	}
	
	private static class Point {
		int x, y, r;
		
		public Point(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}

}
