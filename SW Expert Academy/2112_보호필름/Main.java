import java.io.*;
import java.util.*;


public class Solution {
	static int[][] film;
	static int d, w, k, ans;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			ans = k;
			
			film = new int[d][w];
			
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 0번 시행
			if (k == 1 || check(film)) {
				sb.append("#" + tc + " 0\n");
				continue;
			}
			
			solve(0, 0, film);
			
			sb.append("#" + tc + " " + ans + "\n");
			
		}
		System.out.print(sb);
	}
	
	static void solve(int cnt, int row, int[][] arr) {
		if (cnt > ans)
			return;
		
		if (row == d) {
			if (check(arr)) {
				ans = Math.min(ans, cnt);
			}
			return;
		}
		
		int[][] cArr = copyArr(arr);
		
		
		solve(cnt, row + 1, cArr);
		
		cArr[row] = injection(cArr[row], 0);
		solve(cnt + 1, row + 1, cArr);
		
		cArr[row] = injection(cArr[row], 1);
		solve(cnt + 1, row + 1, cArr);
		
		
	}

	static boolean check(int[][] arr) {
		boolean isSame;
		for (int j = 0; j < w; j++) {
			int cnt = 1;
			int attr = arr[0][j];
			isSame = false;
			
			for (int i = 1; i < d; i++) {
				if (arr[i][j] != attr) {
					cnt = 1;
					attr = arr[i][j];
				} else {
					cnt++;
				}
				if (cnt == k) {
					isSame = true;
					break;
				}
			}
			if (!isSame)
				return false;
		}
		return true;
	}
	
	static int[][] copyArr(int[][] arr) {
		int[][] cArr = new int[d][w];
		
		for (int i = 0; i < d; i++)
			cArr[i] = arr[i].clone();
		
		return cArr;
	}
	
	static int[] injection(int[] arr, int attr) {
		for (int i = 0; i < w; i++) {
			arr[i] = attr;
		}
		return arr;
	}
	
}
