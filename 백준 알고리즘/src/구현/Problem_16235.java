package ±¸Çö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_16235 {
	
	private static Queue<Tree> trees = new PriorityQueue<>((x, y) -> Integer.compare(x.age, y.age));
	private static List<Tree> aliveTrees;
	
	private static int N, M, K;
	private static int[][] A, food, foodToAdd;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		food = new int[N][N];
		foodToAdd = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(food[i], 5);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			trees.add(new Tree(y, x, z));
		}
		
		while (K-- > 0) {
			spring();
			summer();
			autumn();
			winter();
		}
		System.out.println(trees.size());
	}
	
	private static void spring() {
		aliveTrees = new ArrayList<>();
		
		while (!trees.isEmpty()) {
			Tree tree = trees.poll();
			int x = tree.x;
			int y = tree.y;
			int age = tree.age;
			
			if (food[y][x] < age) {
				foodToAdd[y][x] += age / 2;
			} else {
				food[y][x] -= tree.age++;
				aliveTrees.add(tree);
			}
		}
		trees.addAll(aliveTrees);
	}
	
	private static void summer() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				food[i][j] += foodToAdd[i][j];
				foodToAdd[i][j] = 0;
			}
		}
	}
	
	private static void autumn() {
		aliveTrees = new ArrayList<>();
		
		int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
		int[] dy = { 1, 1, 1, 0, -1, -1, -1, 0 };
		
		while (!trees.isEmpty()) {
			Tree tree = trees.poll();
			int x = tree.x;
			int y = tree.y;
			
			if (tree.age % 5 == 0) {
				for (int i = 0; i < 8; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
						continue;
					}
					aliveTrees.add(new Tree(nx, ny, 1));
				}
			}
			aliveTrees.add(tree);
		}
		trees.addAll(aliveTrees);
	}
	
	private static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				food[i][j] += A[i][j];
			}
		}
	}
	
	private static class Tree {
		int x, y;
		int age;
		
		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
	}

}
