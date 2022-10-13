package com.ssafy.day1012.problem;

import java.io.*;
import java.util.*;

public class SWEA_1767 {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	static int n, size, ans;
	static int[][] map;
	static boolean[] isSelected;
	static List<Point> core;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/1767_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			sb.append("#" + tc + " ");
			n = Integer.parseInt(br.readLine());
			ans = Integer.MAX_VALUE;
			map = new int[n][n];
			core = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (i != 0 && j != 0 && map[i][j] == 1) {
						core.add(new Point(i, j));
					}
				}
			}
			
			size = core.size();
			isSelected = new boolean[size];
			
			// 코어가 모두 가장자리에 있음
			if (size == 0) {
				sb.append("0\n");
				continue;
			}
			
			for (int i = size; i >= 0; i--) {
				combi(0, 0, i);
				if (ans < Integer.MAX_VALUE) break;
			}
			
			sb.append(ans + "\n");
		}
		System.out.print(sb);
	}
	
	static void combi(int start, int cnt, int R) {
		if (cnt == R) {
			dfs(0, 0);
			return;
		}
		
		for (int i = start; i < size; i++) {
			isSelected[i] = true;
			combi(i + 1, cnt + 1, R);
			isSelected[i] = false;
		}
		
	}
	
	static void dfs(int idx, int cnt) {
		if (idx == size) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		if (!isSelected[idx]) {
			dfs(idx + 1, cnt);
			return;
		}
		
		// 4방탐색
		for (int i = 0; i < 4; i++) {
			int r = core.get(idx).r;
			int c = core.get(idx).c;
			int tmp = 0;
			boolean flag = false;
			
			while (true) {
				r += dr[i];
				c += dc[i];
				
				// 끝까지 도달 했다면 성공
				if (r < 0 || c < 0 || r >= n || c >= n) {
					flag = true;
					break;
				}
				if (map[r][c] != 0) break;
				map[r][c] = 2;
				tmp++;
			}
			
			// 다음 코어 진행
			if (flag) dfs(idx + 1, cnt + tmp);
			
			// 원상 복구
			while (true) {
				r -= dr[i];
				c -= dc[i];
				if (r == core.get(idx).r && c == core.get(idx).c) break;
				map[r][c] = 0;
			}
		}
		
	}
}
