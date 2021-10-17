package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_16946 {
	
	private static int N, M, num = 2;
	private static int[][] map;
	private static int[][] cache;
	private static boolean[][] visited;
	
	private static Node list = null;
	private static int[] dx = { 0, 1, -1, 0 };
	private static int[] dy = { 1, 0, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cache = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String[] arr = br.readLine().split("");
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					int tmp = dfs(j, i);
					
					for (Node next = list; next != null; next = next.next) {
						cache[next.y][next.x] += tmp; 
					}
					list = null;
					num++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					sb.append((cache[i][j] + 1) % 10);
				} else {
					sb.append(0);
				}
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
	
	private static int dfs(int x, int y) {
		visited[y][x] = true;
		int tmp = 1;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (isInside(nx, ny)) {
				if (map[ny][nx] == 0) {
					if (!visited[ny][nx]) {
						tmp += dfs(nx, ny);
					}
				} else {
					if (map[ny][nx] != num) {
						map[ny][nx] = num;
						list = new Node(nx, ny, list);
					}
				}
			}
		}
		return tmp;
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && y < N && y >= 0 && x < M;
	}
	
	private static class Node {
		int x, y;
		Node next;
		
		public Node(int x, int y, Node node) {
			this.x = x;
			this.y = y;
			next = node;
		}
	}

}
