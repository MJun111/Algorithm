package com.ssafy.day1004.problem;

import java.io.*;
import java.util.*;

public class SWEA_5656 {
	static int n, w, h, ans;
	static int[][] map;
	static int[] order;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/5656_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			ans = 987654321;
			map = new int[h][w];
			order = new int[n];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			permu(0);
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.print(sb);
	}
	
	static void permu(int cnt) {
		if (cnt == n) {
			simulation();
			return;
		}
		
		for (int i = 0; i < w; i++) {
			order[cnt] = i;
			permu(cnt + 1);
		}
		
	}
	
	static void simulation() {
		int[][] copy = copyMap(map);
		
		for (int d = 0; d < n; d++) {
			// 발사
			int idx = -1;
			for (int i = 0; i < h; i++) {
				if (copy[i][order[d]] != 0) {
					idx = i;
					break;
				}
			}
			
			if (idx == -1) continue;
			
			// hit
			// 1이면 해당 칸만 삭제
			if (copy[idx][order[d]] == 1) copy[idx][order[d]] = 0;
			// 2 이상이면 연쇄 삭제
			else {
				breakBrick(idx, order[d], copy);
				downBrick(copy);
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (copy[i][j] != 0) cnt++;
			}
		}
		
		ans = Math.min(ans, cnt);
	}
	
	static void downBrick(int[][] copy) {
		for (int j = 0; j < w; j++) {
			Queue<Integer> q = new ArrayDeque<>();
			for (int i = h - 1; i >= 0; i--) {
				if (copy[i][j] != 0) {
					q.add(copy[i][j]);
					copy[i][j] = 0;
				}
			}
			
			int idx = h - 1;
			while (!q.isEmpty()) {
				copy[idx--][j] = q.poll();
			}
		}
	}

	static void breakBrick(int y, int x, int[][] copy) {
		int num = copy[y][x];
		
		copy[y][x] = 0;
		
		for (int i = 0; i < 4; i++) {
			int ny = y;
			int nx = x;
			
			for (int j = 0; j < num - 1; j++) {
				ny += dy[i];
				nx += dx[i];
				
				if (ny < 0 || nx < 0 || ny >= h || nx >= w) break;
				if (copy[ny][nx] == 0) continue;
				if (copy[ny][nx] == 1) {
					copy[ny][nx] = 0;
					continue;
				}
				
				breakBrick(ny, nx, copy);
			}
		}
		
	}

	static int[][] copyMap(int[][] arr) {
		int[][] copy = new int[h][w];
		for (int i = 0; i < h; i++) 
			copy[i] = arr[i].clone();
		
		return copy;
	}
	
}
