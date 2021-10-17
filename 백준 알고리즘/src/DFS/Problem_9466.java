package DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_9466 {
	
	private static int answer, visit = -1;
	private static int[] graph;
	private static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
			int n = Integer.parseInt(br.readLine());
			graph = new int[n + 1];
			visited = new int[n + 1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				graph[i] = Integer.parseInt(st.nextToken());
			}
			
			answer = n;
			visit = -1;
			for (int i = 1; i <= n; i++) {
				if (visited[i] == 0) {
					int c = 1;
					int cur = i;
					
					while (true) {
						visited[cur] = visit;
						
						if (cur == graph[cur]) {
							answer--;
						} else {
							int next = graph[cur];
							
							if (visited[next] == 0) {
								cur = next;
								c++;
								continue;
							}
							if (visited[next] == visit) {
								answer -= c;
							}
						}
						break;
					}
					visit--;
				}
			}
			bw.write(answer + "\n");
		}
		bw.close();
	}

}
