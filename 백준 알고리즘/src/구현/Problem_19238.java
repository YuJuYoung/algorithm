package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_19238 {
	
	private static int N, M;
	private static int[][] map;
	private static Taxi taxi;
	
	private static Map<Integer, Point> hm = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int fuel = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		taxi = new Taxi(new Point(x, y), fuel);
		
		// 승객 탑승 위치, 목적지 저장
		for (int i = 2; i < M + 2; i++) {
			st = new StringTokenizer(br.readLine());
			
			int passenger_y = Integer.parseInt(st.nextToken());
			int passenger_x = Integer.parseInt(st.nextToken());
			int goal_y = Integer.parseInt(st.nextToken());
			int goal_x = Integer.parseInt(st.nextToken());
			
			map[passenger_y][passenger_x] = i;
			hm.put(i, new Point(goal_y, goal_x));
		}
	}
	
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };
	
	private static boolean findPassenger() {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		q.add(taxi.p);
		visited[taxi.p.y][taxi.p.x] = true;
		
		int distance = 1;
		
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				Point p = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					
					if (isInside(nx, ny) && map[ny][nx] != 0) {
						Point np = new Point(nx, ny);
						
						if (map[ny][nx] > 1) {
							taxi.p = np;
							taxi.fuel -= distance;
							
							return true;
						}
						
						q.add(np);
						visited[nx][ny] = true;
					}
				}
			}
			
			if (++distance >= taxi.fuel) {
				return false;
			}
		}
		
		return false;
	}
	
	private static boolean isInside(int x, int y) {
		return !(x < 0 || x >= N || y < 0 || y >= N);
	}
	
	private static class Taxi {
		// 택시의 위치
		Point p;
		
		int fuel, passenger_num;
		
		private Taxi(Point p, int fuel) {
			this.p = p;
			this.fuel = fuel;
			passenger_num = 0;
		}
	}
	
	private static class Point {
		int x, y;
		
		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
