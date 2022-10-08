package com.ssafy.day1007.problem;

import java.io.*;
import java.util.*;

public class BOJ_2146 {
	static class Point {
		int r, c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int n, ans;
	static int[][] map;
	static List<Point>[] island = new ArrayList[10000];
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1][n + 1];
		map = new int[n + 1][n + 1];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && map[i][j] == 1)
					findIsland(i, j, idx++);				
			}
		}
		
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < idx - 1; i++) {
			for (int j = i + 1; j < idx; j++) {
				findLength(island[i], island[j]);
			}
		}
		
		System.out.println(ans - 1);
	}
	
	static void findIsland(int r, int c, int idx) {
		island[idx] = new ArrayList<>();
		island[idx].add(new Point(r, c));
		Queue<Point> q = new ArrayDeque<>();
		visited[r][c] = true;
		q.add(new Point(r, c));
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
				if (visited[nr][nc]) continue;
				if (map[nr][nc] == 0) continue;
				
				visited[nr][nc] = true;
				q.add(new Point(nr, nc));
				island[idx].add(new Point(nr, nc));
			}
		}
	}
	
	static void findLength(List<Point> island1, List<Point> island2) {
		for (int i = 0; i < island1.size(); i++) {
			for (int j = 0; j < island2.size(); j++) {
				ans = Math.min(ans, getDist(island1.get(i), island2.get(j)));
			}
		}
	}
	
	static int getDist(Point p1, Point p2) {
		return Math.abs(p1.r - p2.r) + Math.abs(p1.c - p2.c);
	}
	
}
