package ±×·¡ÇÁ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_1865 {
	
	private static int N, M, W;
	private static int[][] road, hole;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int TC = Integer.parseInt(br.readLine()); TC > 0; TC--) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			road = new int[M * 2 + 1][3];
			hole = new int[W + 1][3];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < 3; j++) {
					road[i * 2][j] = Integer.parseInt(st.nextToken());
				}
				road[i * 2 + 1][0] = road[i * 2][1];
				road[i * 2 + 1][1] = road[i * 2][0];
				road[i * 2 + 1][2] = road[i * 2][2];
			}
			
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < 2; j++) {
					hole[i][j] = Integer.parseInt(st.nextToken());
				}
				hole[i][2] = -Integer.parseInt(st.nextToken());
			}
			bw.write(getAnswer());
			bw.newLine();
		}
		bw.close();
	}
	
	private static String getAnswer() {
		for (int t = 1; t <= N; t++) {
			int[] dist = new int[N + 1];
			
			for (int i = 1; i <= N; i++) {
				if (i != t) {
					dist[i] = Integer.MAX_VALUE;
				}
			}
			
			for (int i = 0; i < N; i++) {
				int[] temp = new int[N + 1];
				
				for (int j = 1; j <= N; j++) {
					temp[j] = dist[j];
				}
				setTemp(dist, temp, road);
				setTemp(dist, temp, hole);
				
				if (temp[t] < 0) {
					return "YES";
				}
				dist = temp;
			}
		}
		return "NO";
	}
	
	private static void setTemp(int[] dist, int[] temp, int[][] arr) {
		for (int[] info : arr) {
			int s = info[0];
			int e = info[1];
			int t = info[2];
			
			if (dist[s] != Integer.MAX_VALUE) {
				temp[e] = Math.min(temp[e], dist[s] + t);
			}
		}
	}

}
