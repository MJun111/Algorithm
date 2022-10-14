package com.ssafy.day1012.problem;

import java.io.*;
import java.util.*;

public class SWEA_1949 {
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int n, k, ans;
	static int[][] map;
	static boolean[][] visited;
	static List<Point> high;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/1949_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			high = new ArrayList<>();
			ans = 0;
			map = new int[n][n];
			
			int max = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					// max 갱신 되면 이전 까지 제일 높은 값들 새로 갱신
					if (map[i][j] > max) {
						max = map[i][j];
						high.clear();
					} 
					if (map[i][j] == max) {
						high.add(new Point(i, j));
					}
				}
			}

			for (int i = 0; i < high.size(); i++) {
				visited = new boolean[n][n];
				visited[high.get(i).r][high.get(i).c] = true;
				dfs(high.get(i).r, high.get(i).c, 1, false);
			}
			
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.print(sb);
	}
	
	static void dfs(int r, int c, int len, boolean flag) {
		ans = Math.max(ans, len);
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
			if (visited[nr][nc]) continue;
			
			if (map[nr][nc] < map[r][c]) {
				visited[nr][nc] = true;
				dfs(nr, nc, len + 1, flag);
				visited[nr][nc] = false;
			} else {
				if (!flag && map[nr][nc] - k < map[r][c]) {
					int val = map[nr][nc];
					map[nr][nc] = map[r][c] - 1;
					visited[nr][nc] = true;
					dfs(nr, nc, len + 1, true);
					visited[nr][nc] = false;
					map[nr][nc] = val;
				}
			}
		}
	}
	
}
