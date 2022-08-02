package com.ssafy.day0802.problem;

import java.util.*;
import java.io.*;

public class SWEA_1210_Ladder1 {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/1210_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = 10;
		int size = 100;
		
		while(t-- > 0) {
			int ans = -1;
			int tc = Integer.parseInt(br.readLine());
			int target = -1;
			int[] dx = {0, -1, 1};
			int[] dy = {-1, 0, 0};
			int[][] map = new int[size][size];
			
			for (int i = 0; i < size; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < size; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2)
						target = j;
				}
			}
			
			int y = size - 1;
			int x = target;
			int dir = 0;
			boolean[][] visited = new boolean[size][size];
			while(y != 0) {
				visited[y][x] = true;
				if (x - 1 >= 0 && map[y][x - 1] == 1 && !visited[y][x - 1])
					dir = 1;
				else if (x + 1 < size && map[y][x + 1] == 1 && !visited[y][x + 1])
					dir = 2;
				else
					dir = 0;
				
				x += dx[dir];
				y += dy[dir];
			}
			
			System.out.println("#" + tc + " " + x);
		}
		
	}
	
}
