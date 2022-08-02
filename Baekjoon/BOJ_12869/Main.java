import java.io.*;
import java.util.*;

/*
 * 1순위 -9
 * 2순위 -3
 * 3순위 -1
 * SCV 체력 0이하 -> 파괴
 * 한 번의 공격에 같은 SCV를 중복해서 공격 불가
 * 공격의 최솟값
 * 
 */

public class Main {
	static int n;
	static int result = Integer.MAX_VALUE;
	static int[] scv;
	static int[][][] dp;
	public static void main(String[] args) throws IOException {
		input();
		attack(scv, 0);

		System.out.println(result);
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		scv = new int[3];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			scv[i] = Integer.parseInt(st.nextToken());
		
		dp = new int[61][61][61];
	}
	
	static int[] attackA = {9, 9, 3, 3, 1, 1};
	static int[] attackB = {3, 1, 9, 1, 9, 3};
	static int[] attackC = {1, 3, 1, 9, 3, 9};

	static void attack(int[] scv, int cnt) {
		int a = scv[0];
		int b = scv[1];
		int c = scv[2];
		
		if (dp[a][b][c] != 0 && dp[a][b][c] <= cnt) 
			return;
		
		if (a == 0 && b == 0 && c == 0) {
			result = Math.min(result, cnt);
			return;
		}
		
		dp[a][b][c] = cnt;
		
		int nA, nB, nC;
		for (int i = 0; i < 6; i++) {
			nA = a - attackA[i];
			nB = b - attackB[i];
			nC = c - attackC[i];
			
			if (nA < 0) nA = 0;
			if (nB < 0) nB = 0;
			if (nC < 0) nC = 0;
			
			attack(new int[] {nA, nB, nC}, cnt + 1);
		}
		
	}
	
}
