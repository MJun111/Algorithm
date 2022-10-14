import java.io.*;
import java.util.*;

public class Solution {
	static int d, w, k, ans;
	static int[][] film, copy;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			sb.append("#" + tc + " ");
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			film = new int[d][w];
			copy = new int[d][w];			
			
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					film[i][j] = copy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			if (k == 1 || check()) {
				sb.append("0\n");
				continue;
			}
			
			simulation(0, 0);
			sb.append(ans + "\n");
		}
		System.out.print(sb);
	}
	
	static void simulation(int row, int cnt) {
		if (cnt > ans) return;
		
		if (row == d) {
			if (check())
				ans = Math.min(cnt, ans);
			return;
		}
		
		// 약물 주입 X
		simulation(row + 1, cnt);
		
		// 약물 A 주입
		injection(row, 0);
		simulation(row + 1, cnt + 1);
		
		// 약물 B 주입
		injection(row, 1);
		simulation(row + 1, cnt + 1);
		
		for (int j = 0; j < w; j++) {
			film[row][j] = copy[row][j];
		}
	}
	
	static boolean check() {
		boolean flag;
		for (int j = 0; j < w; j++) {
			flag = false;
			int cnt = 1;
			int attr = film[0][j];
			
			for (int i = 1; i < d; i++) {
				if (attr == film[i][j]) cnt++;
				else {
					cnt = 1;
					attr = film[i][j];
				}
				if (cnt == k) {
					flag = true;
					break;
				}
			}
			
			if (!flag)
				return false;
		}
		
		return true;
	}
	
	static void injection(int row, int attr) {
		for (int j = 0; j < w; j++) {
			film[row][j] = attr;
		}
	}
	
}
