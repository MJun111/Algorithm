package com.ssafy.day1006.problem;

import java.io.*;
import java.util.*;

/*
 * 맥주 1박스 = 1km = 1000m 이동 가능
 * 
 */

public class BOJ_9205 {
	static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int n;
	static Point home, festival;
	static List<Point> list;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			
			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());				
				list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			bfs();
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		boolean[] visited = new boolean[n + 2];
		Queue<Point> q = new ArrayDeque<>();
		
		q.add(list.get(0));
		visited[0] = true;
		
		while (!q.isEmpty()) {
			Point cur = q.poll();
			
			// 페스티벌 도착
			if (visited[n + 1] == true) {
				sb.append("happy\n");
				return;
			}
			
			for (int i = 0; i < n + 2; i++) {
				Point next = list.get(i);
				
				if (getDistance(cur, next) <= 1000 && !visited[i]) {
					visited[i] = true;
					q.add(next);
				}
			}
		}
		sb.append("sad\n");
	}
	
	static int getDistance(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
	
}
