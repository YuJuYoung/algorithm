package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_19238 {
	
	private static int N, M;
	private static int[][] map = null;
	private static Taxi taxi = new Taxi();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		taxi.fuel = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		taxi.y = Integer.parseInt(st.nextToken()) - 1;
		taxi.x = Integer.parseInt(st.nextToken()) - 1;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int passengerY = Integer.parseInt(st.nextToken()) - 1;
			int passengerX = Integer.parseInt(st.nextToken()) - 1;
			int goalY = Integer.parseInt(st.nextToken()) - 1;
			int goalX = Integer.parseInt(st.nextToken()) - 1;
			// 예) goalY이 10, goalX가 12라면 map[passangerY][passengerX]은 11012;
			map[passengerY][passengerX] = goalY * 100 + goalX + 10000;
		}
		
		System.out.println(solve());
	}
	
	private static int solve() {
		for (int i = 0; i < M; i++) {
			Point goalPoint = moveToPassenger();
			if (goalPoint == null) {
				return -1;
			}
			if (!takePassenger(goalPoint)) {
				return -1;
			}
		}
		return taxi.fuel;
	}
	
	// 무사히 손님에게 도착했다면 손님의 목표 위치를, 아니면 null을 반환
	private static Point moveToPassenger() {
		if (map[taxi.y][taxi.x] >= 10000) {
			int goalCode = map[taxi.y][taxi.x];
			map[taxi.y][taxi.x] = 0;
			return decodeGoalCode(goalCode);
		}
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(taxi.y, taxi.x));
		boolean[][] visited = new boolean[N][N];
		visited[taxi.y][taxi.x] = true;
		
		// 상, 하, 좌, 우 좌표를 구할때 사용
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		// BFS
		while (taxi.fuel-- > 0 && !q.isEmpty()) {
			int size = q.size();
			
			// 승객의 탑승 위치
			Point resPassengerPoint = null;
			// 발견한 승객의 목표의 위치
			Point resGoalPoint = null;
			
			while (size-- > 0) {
				Point temp = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nextX = temp.x + dx[i];
					int nextY = temp.y + dy[i];
					
					if (isInside(nextX, nextY) && map[nextY][nextX] != 1 && !visited[nextY][nextX]) {
						if (map[nextY][nextX] >= 10000) {
							Point goalPoint = decodeGoalCode(map[nextY][nextX]);
							Point passengerPoint = new Point(nextY, nextX);
							
							if (resGoalPoint == null || resPassengerPoint == null) {
								resGoalPoint = goalPoint;
								resPassengerPoint = passengerPoint;
							} else {
								if (resPassengerPoint.compareTo(passengerPoint) > 0) {
									resGoalPoint = goalPoint;
									resPassengerPoint = passengerPoint;
								}
							}
						} else {
							if (resGoalPoint == null) {
								q.add(new Point(nextY, nextX));
								visited[nextY][nextX] = true;
							}
						}
					}
				}
			}
			if (resGoalPoint != null && resPassengerPoint != null) {
				map[resPassengerPoint.y][resPassengerPoint.x] = 0;
				// 택시의 위치를 승객의 위치로 변경
				taxi.x = resPassengerPoint.x;
				taxi.y = resPassengerPoint.y;
				return resGoalPoint;
			}
		}
		return null;
	}
	
	// 정수 타입의 코드를 Point 객체로 변환
	private static Point decodeGoalCode(int goalCode) {
		goalCode -= 10000;
		int goalY = goalCode / 100;
		int goalX = goalCode % 100;
		return new Point(goalY, goalX);
	}
	
	// 승객을 데려다주는데 성공하면 true, 실패하면 false를 반환
	private static boolean takePassenger(Point goalPoint) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(taxi.y, taxi.x));
		boolean[][] visited = new boolean[N][N];
		visited[taxi.y][taxi.x] = true;
		int distance = 0;
		
		// 상, 하, 좌, 우 좌표를 구할때 사용
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		// BFS
		while (distance++ < taxi.fuel && !q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				Point temp = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nextX = temp.x + dx[i];
					int nextY = temp.y + dy[i];
					
					if (isInside(nextX, nextY) && map[nextY][nextX] != 1 && !visited[nextY][nextX]) {
						if (nextX == goalPoint.x && nextY == goalPoint.y) {
							taxi.x = goalPoint.x;
							taxi.y = goalPoint.y;
							/* 아래 식은 다음 식을 간추린 식
							 * taxi.fuel -= distance;
							 * taxi.fuel += distance * 2; 
							 * */
							taxi.fuel += distance;
							return true;
						} else {
							q.add(new Point(nextY, nextX));
							visited[nextY][nextX] = true;
						}
					}
				}
			}
		}
		return false;
	}
	
	private static boolean isInside(int x, int y) {
		return !(x >= N || x < 0 || y >= N || y < 0);
	}
	
	private static class Taxi {
		int x, y;
		int fuel;
	}
	
	private static class Point implements Comparable<Point> {
		int x, y;
		
		public Point(int y, int x) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Point p) {
			if (y < p.y || (y == p.y && x < p.x)) {
				return -1;
			}
			if (y == p.y && x == p.x) {
				return 0;
			}
			return 1;
		}
	}
	
}