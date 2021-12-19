package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_17478 {
	
	private static final String QUESTION = "\"재귀함수가 뭔가요?\"\n";
	private static final String[] ANSWER = {
		"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
		"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
		"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n",
		"라고 답변하였지.\n",
		"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n"
	};
	
	private static StringBuilder result = new StringBuilder();
	private static StringBuilder dist = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		result.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		dfs(Integer.parseInt(br.readLine()));
		System.out.print(result);
	}
	
	private static void dfs(int n) {
		append(QUESTION);
		
		if (n == 0) {
			append(ANSWER[4]);
		} else {
			for (int i = 0; i <= 2; i++) {
				append(ANSWER[i]);
			}
			dist.append("____");
			dfs(n - 1);
			dist.delete(dist.length() - 4, dist.length());
		}
		append(ANSWER[3]);
	}
	
	private static void append(String str) {
		result.append(dist);
		result.append(str);
	}

}
