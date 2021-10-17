package ±¸Çö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_15686 {
	
	private static List<int[]> chicken = new ArrayList<>();
	private static List<House> house = new ArrayList<>();
	
	private static int ans = Integer.MAX_VALUE;
	private static boolean[] opened;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < N; j++) {
				char c = str.charAt(j * 2);
				
				if (c != '0') {
					if (c == '1') {
						house.add(new House(j, i));
					} else {
						chicken.add(new int[] { j, i });
					}
				}
			}
		}
		
		for (House h : house) {
			h.setDist();
		}
		opened = new boolean[chicken.size()];
		
		if (chicken.size() <= M) {
			int sum = 0;
			
			for (House h : house) {
				sum += h.dist[0][0];
			}
			ans = sum;
		} else {
			dfs(-1, 0, M);
		}
		System.out.println(ans);
	}
	
	private static void dfs(int last, int count, int M) {
		if (count == M) {
			ans = Math.min(ans, calDist());
		} else {
			for (int i = last + 1; i <= chicken.size() - M + count; i++) {
				if (!opened[i]) {
					opened[i] = true;
					dfs(i, count + 1, M);
					opened[i] = false;
				}
			}
		}
	}
	
	private static int calDist() {
		int sum = 0;
		
		for (House h : house) {
			for (int[] dist : h.dist) {
				if (opened[dist[1]]) {
					sum += dist[0];
					break;
				}
			}
		}
		return sum;
	}
	
	private static class House {
		int x, y;
		int[][] dist;
		
		public House(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public void setDist() {
			dist = new int[chicken.size()][2];
			
			for (int i = 0; i < chicken.size(); i++) {
				int[] tmp = chicken.get(i);
				
				dist[i][0] = Math.abs(x - tmp[0]) + Math.abs(y - tmp[1]);
				dist[i][1] = i;
			}
			Arrays.sort(dist, (x, y) -> Integer.compare(x[0], y[0]));
		}
	}

}
