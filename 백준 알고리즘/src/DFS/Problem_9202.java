package DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem_9202 {
	
	private static String[] words;
	private static char[][] arr;
	private static boolean[][] visited = new boolean[4][4];
	private static int[] point = { 0, 0, 1, 1, 2, 3, 5, 11 };
	
	private static String word;
	private static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	private static int[] dy = { 0, 0, 1, -1, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int w = Integer.parseInt(br.readLine());
		words = new String[w];
		
		for (int i = 0; i < w; i++) {
			words[i] = br.readLine();
		}
		Arrays.sort(words);
		br.readLine();
		
		int b = Integer.parseInt(br.readLine());
		while (true) {
			arr = new char[4][4];
			
			for (int i = 0; i < 4; i++) {
				String str = br.readLine();
				
				for (int j = 0; j < 4; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			
			int count = 0;
			int sum = 0;
			String str = "";
			
			for (String tmp : words) {
				word = tmp;
				
				boolean flag = false;
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						if (arr[i][j] == word.charAt(0) && dfs(j, i, 1)) {
							int len = word.length();
							
							if (str.length() < len) {
								str = word;
							}
							sum += point[len - 1];
							count++;
							flag = true;
							break;
						}
					}
					if (flag) {
						break;
					}
				}
			}
			bw.write(sum + " " + str + " " + count);
			bw.newLine();
			
			if (--b == 0) {
				break;
			}
			br.readLine();
		}
		bw.close();
	}
	
	private static boolean dfs(int x, int y, int len) {
		if (len == word.length()) {
			return true;
		}
		visited[y][x] = true;
		
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (isInside(nx, ny) && arr[ny][nx] == word.charAt(len) && !visited[ny][nx]) {
				if (dfs(nx, ny, len + 1)) {
					visited[y][x] = false;
					return true;
				}
			}
		}
		visited[y][x] = false;
		
		return false;
	}
	
	private static boolean isInside(int x, int y) {
		return x >= 0 && x < 4 && y >= 0 && y < 4;
	}

}
