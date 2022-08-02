package com.ssafy.day0802.problem;

import java.util.*;
import java.io.*;

public class SWEA_1210_Ladder1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = 10;
		
		while(t-- > 0) {
			int ans = -1;
			int tc = Integer.parseInt(br.readLine());
			int[] dx = {0, 1, -1};
			int[] dy = {1, 0, 0};
			int[][] map = new int[100][100];
			
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 시작 좌표를 담을 큐
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < 100; i++) 
				if (map[0][i] == 1)
					q.add(i);
			
			while(!q.isEmpty()) {
				int startX = q.poll();
				int x = startX;
				int y = 0;
				int dir;	
				boolean[][] visited = new boolean[100][100];
				
				while(true) {
					visited[y][x] = true; 
					if (x + 1 < 100 && map[y][x + 1] == 1 && !visited[y][x + 1])
						dir = 1;
					else if (x - 1 >= 0 && map[y][x - 1] == 1 && !visited[y][x - 1])
						dir = 2;
					else
						dir = 0;
					
					switch(dir) {
					case 0: y++; break;
					case 1: x++; break;
					case 2: x--; break;
					}
					
					if (y == 99) {
						if (x == 99)
							ans = startX;
						break;
					}
					
				}
				if (ans != -1)
					break;
			}
			
			System.out.println("#" + tc + " " + ans);
		}
		
	}
	
}
