package com.ssafy.day1006.problem;

import java.io.*;
import java.util.*;

public class BOJ_5427 {
	static int w, h;
	static char[][] map;
	static int[][] distS;
	static int[][] distF;
	
	static Queue<int[]> sq;
	static Queue<int[]> fq;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h][];
			distS = new int[h][w];
			distF = new int[h][w];
			sq = new ArrayDeque<>();
			fq = new ArrayDeque<>();

			for (int i = 0; i < h; i++) {
				Arrays.fill(distF[i], -1);
				Arrays.fill(distS[i], -1);
			}
			
			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < w; j++) {
					if (map[i][j] == '*') {
						fq.add(new int[] {i, j});
						distF[i][j] = 0;
					}
					if (map[i][j] == '@') {
						sq.add(new int[] {i, j});
						distS[i][j] = 0;
					}
				}
			}
			
			bfsF();
			bfsS();
		}
		System.out.print(sb);
	}
	
	static void bfsF() {
		if (fq.size() < 1) return;
		int[] fire = fq.peek();
		
		while (!fq.isEmpty()) {
			int[] cur = fq.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
				if (distF[nr][nc] != -1) continue;
				if (map[nr][nc] == '#') continue;
				
				distF[nr][nc] = distF[cur[0]][cur[1]] + 1;
				
				fq.add(new int[] {nr, nc});
			}
		}
	}
	
	static void bfsS() {
		int[] sang = sq.peek();
		
		while (!sq.isEmpty()) {
			int[] cur = sq.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= h || nc >= w) {
					sb.append(distS[cur[0]][cur[1]] + 1 + "\n");
					return;
				}
				if (distF[nr][nc] != -1 && distF[nr][nc] <= distS[cur[0]][cur[1]] + 1) continue;
				if (distS[nr][nc] != -1) continue;
				if (map[nr][nc] == '#') continue;
				
				distS[nr][nc] = distS[cur[0]][cur[1]] + 1;
				
				sq.add(new int[] {nr, nc});
			}
		}
		sb.append("IMPOSSIBLE\n");
	}
}
