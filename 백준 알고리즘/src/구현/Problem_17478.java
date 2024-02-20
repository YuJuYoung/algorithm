package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_17478 {
	
	private static final String QUESTION = "\"����Լ��� ������?\"\n";
	private static final String[] ANSWER = {
		"\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n",
		"���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n",
		"���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n",
		"��� �亯�Ͽ���.\n",
		"\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n"
	};
	
	private static StringBuilder result = new StringBuilder();
	private static StringBuilder dist = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		result.append("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.\n");
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
