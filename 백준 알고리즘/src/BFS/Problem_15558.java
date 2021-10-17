package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_15558 {
	
	private static int N, k;
	private static char[][] lines;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		lines = new char[N][2];
		
		for (int i = 0; i < 2; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < N; j++) {
				lines[j][i] = str.charAt(j);
			}
		}
		System.out.println(bfs());
	}
	
	private static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0));
		lines[0][0] = '0';
		
		int time = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				Point p = q.poll();
				int line = p.line;
				int cur = p.current;
				if (cur + 1 >= N || cur + k >= N) {
					return 1;
				}
				
				if (lines[cur + 1][line] == '1') {
					lines[cur + 1][line] = '0';
					q.add(new Point(line, cur + 1));
				}
				if (cur > time) {
					if (lines[cur - 1][line] == '1') {
						lines[cur - 1][line] = '0';
						q.add(new Point(line, cur - 1));
					}
				}
				int tmp = (line + 1) % 2;
				
				if (lines[cur + k][tmp] == '1') {
					lines[cur + k][tmp] = '0';
					q.add(new Point(tmp, cur + k));
				}
			}
			time++;
		}
		return 0;
	}
	
	private static class Point {
		int line, current;
		
		public Point(int line, int current) {
			this.line = line;
			this.current = current;
		}
	}

}
