package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_11559 {
	
	private static final char BLANK = '.';
	
	private static char[][] field;
	private static boolean[][] visited;
	private static Queue<Point> boom = new LinkedList<>(); 
	
	private static Node node;
	private static int[] dx = { 1, 0, 0, -1 }, dy = { 0, 1, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		field = new char[12][6];
		
		for (int i = 0; i < 12; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < 6; j++) {
				field[i][j] = str.charAt(j);
			}
		}
		
		int time = 0;
		while (true) {
			visited = new boolean[12][6];
			node = null;
			
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (field[i][j] != BLANK) {
						bfs(j, i);
					}
				}
			}
			
			if (boom.isEmpty()) {
				break;
			}
			while (!boom.isEmpty()) {
				Point p = boom.poll();
				field[p.y][p.x]= BLANK; 
			}
			down();
			time++;
		}
		System.out.println(time);
	}
	
	private static void bfs(int x, int y) {
		node = null;
		
		Queue<Point> q = new LinkedList<>();
		add(q, new Point(x, y));
		
		int count = 1;
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (isInside(nx, ny) && !visited[ny][nx]) {
					if (field[ny][nx] == field[y][x]) {
						Point tmp = new Point(nx, ny);
						
						add(q, tmp);
						count++;
					}
				}
			}
		}
		
		if (count >= 4) {
			for (Node next = node; next != null; next = next.next) {
				boom.add(next.p);
			}
		}
	}
	
	private static void down() {
		for (int i = 11; i > 0; i--) {
			for (int j = 0; j < 6; j++) {
				if (field[i][j] == '.') {
					int tmp = i;
					
					while (tmp-- > 0) {
						if (field[tmp][j] != BLANK) {
							field[i][j] = field[tmp][j];
							field[tmp][j] = BLANK;
							break;
						}
					}
				}
			}
		}
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < 6 && y >= 0 && y < 12;
	}
	
	private static void add(Queue<Point> q, Point p) {
		q.add(new Point(p.x, p.y));
		visited[p.y][p.x] = true;
		node = new Node(p, node);
	}
	
	private static class Node {
		Point p;
		Node next;
		
		public Node(Point p, Node next) {
			this.p = p;
			this.next = next;
		}
	}
	
	private static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
