import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int cnt = 0;
	static String line = "____";
	static String[] str = { "\"재귀함수가 뭔가요?\"", 
							"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
							"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.", 
							"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"",
							"\"재귀함수가 뭔가요?\"", 
							"\"재귀함수는 자기 자신을 호출하는 함수라네\"", 
							"라고 답변하였지." };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다." + "\n");
		print(n);
		System.out.println(sb);
	}

	static void print(int n) {
		if (n < 1) {
			for (int i = 4; i < 7; i++) {
				for (int j = 0; j < cnt; j++) {
					sb.append(line);
				}
				sb.append(str[i] + "\n");
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < cnt; j++) {
				sb.append(line);
			}
			sb.append(str[i] + "\n");
		}
		cnt++;
		print(n - 1);
		cnt--;
		for (int j = 0; j < cnt; j++)
			sb.append(line);

		sb.append(str[6] + "\n");
	}
}
