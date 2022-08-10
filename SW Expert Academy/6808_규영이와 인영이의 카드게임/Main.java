import java.util.*;
import java.io.*;

/*
 * 1~18 적힌 배열
 * input 배열 - 1)
 * input에서 고르지 않은 나머지 수 배열 - 2)
 * 
 * 2)에서 순열
 * 
 * 이기는지 지는지 카운트
 * 
 * 
 */

public class Main {
	static int win, lose;	// 규영이 기준 승, 패
	static int[] a, b, seq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			
			// 1~18 숫자가 뽑혔는지 체크
			boolean[] isPicked = new boolean[19];
			
			// a : 규영, b : 인영
			a = new int[9];
			b = new int[9];
			win = 0; 
			lose = 0;
			
			st = new StringTokenizer(br.readLine());
			
			// 규영이 숫자
			for (int i = 0; i < 9; i++) {
				a[i] = Integer.parseInt(st.nextToken());
				isPicked[a[i]] = true;
			}
			
			// 인영이 숫자
			int j = 0;
			for (int i = 1; i <= 18; i++) {
				if (!isPicked[i])
					b[j++] = i;
			}
			
			// 인영이가 내는 순서
			seq = new int[9];
			permu(new boolean[9], 0);
			
			sb.append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
	}
	
	static void permu(boolean[] visited, int depth) {
		if (depth == 9) {
			play();
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				seq[depth] = b[i];
				permu(visited, depth + 1);
				visited[i] = false;
			}
		}
		
	}
	
	static void play() {
		int a_score = 0;
		int b_score = 0;
		
		for (int i = 0; i < 9; i++) {
			int res = a[i] - seq[i];
			if (res > 0)
				a_score += a[i] + seq[i];
			else
				b_score += a[i] + seq[i];
		}
		
		if (a_score > b_score)
			win++;
		if (a_score < b_score)
			lose++;
	}
}
