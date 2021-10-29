package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_10265 {
	
	private static int n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		if (n <= k) {
			System.out.println(n);
		} else {
			
		}
	}

}
