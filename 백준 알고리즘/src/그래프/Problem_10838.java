package ±×·¡ÇÁ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem_10838 {
	
	private static int N, K;
	private static int[] parent;
	private static int[] color;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		parent = new int[N];
		color = new int[N];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (r == 1) {
				paint(a, b, Integer.parseInt(st.nextToken()));
			} else if (r == 2) {
				move(a, b);
			} else {
				bw.write(count(a, b) + "\n");
			}
		}
		bw.close();
	}
	
	private static void paint(int a, int b, int c) {
		int root = getRoot(a, b);
		
		while (a != root) {
			color[a] = c;
			a = parent[a];
		}
		while (b != root) {
			color[b] = c;
			b = parent[b];
		}
	}
	
    private static void move(int a, int b) {
    	parent[a] = b;
	}
    
    private static int count(int a, int b) {
    	Set<Integer> hs = new HashSet<>();
		int root = getRoot(a, b);
		
		while (a != root) {
			hs.add(color[a]);
			a = parent[a];
		}
		while (b != root) {
			hs.add(color[b]);
			b = parent[b];
		}
		return hs.size();
	}
    
    private static int getRoot(int a, int b) {
    	boolean[] visited = new boolean[N];
    	
    	while (a != b) {
    		if (a != 0) {
    			visited[a] = true;
    		}
    		if (b != 0) {
    			visited[b] = true;
    		}
    		
    		if (visited[parent[a]]) {
    			return parent[a];
    		}
    		if (visited[parent[b]]) {
    			return parent[b];
    		}
    		a = parent[a];
    		b = parent[b];
    	}
    	return a;
    }

}
