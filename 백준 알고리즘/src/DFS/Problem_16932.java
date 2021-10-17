package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem_16932 {
	
	private static int N, M;
	private static int[][] arr;
	private static int[] cache = new int[50005];
	
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int color = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					cache[color] = bfs(j, i, color++);
				}
			}
		}
		
		Set<Integer> hs = new HashSet<>();
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					hs.clear();
					
					int sum = 1;
					for (int k = 0; k < 4; k++) {
						int nx = j + dx[k];
						int ny = i + dy[k];
						
						if (isInside(nx, ny)) {
							hs.add(arr[ny][nx]);
						}
					}
					for (int tmp : hs) {
						sum += cache[tmp];
					}
					max = Math.max(max, sum);
				}
			}
		}
		System.out.println(max);
	}
	
	private static int bfs(int x, int y, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		arr[y][x] = c;
		
		int count = 1;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				
				if (isInside(nx, ny) && arr[ny][nx] == 1) {
					q.add(new int[] { nx, ny });
					arr[ny][nx] = c;
					count++;
				}
			}
		}
		return count;
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < M && y >= 0 && y < N;
	}

}
