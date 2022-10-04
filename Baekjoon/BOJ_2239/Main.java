package com.ssafy.day1004.problem;

import java.io.*;
import java.util.*;

public class BOJ_2239 {
	static int[][] board = new int[9][9];
	static boolean[][][] isIn = new boolean[3][9][10];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				board[i][j] = c[j] - '0';
				// 행
				isIn[0][i][board[i][j]] = true;
				// 열
				isIn[1][j][board[i][j]] = true;
				// 구역
				isIn[2][getSector(i, j)][board[i][j]] = true;
			}
		}
		
		dfs(0, 0);
		
	}
	
	static void dfs(int r, int c) {
		if (r == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		int nr = r, nc = c;
		
		if (c == 8) {
			nr++;
			nc = 0;
		} else 
			nc++;
		
		
		if (board[r][c] != 0)
			dfs(nr, nc);
		else {
			for (int k = 1; k <= 9; k++) {
				if (isIn[0][r][k] || isIn[1][c][k] || isIn[2][getSector(r, c)][k]) continue;
				isIn[0][r][k] = true;
				isIn[1][c][k] = true;
				isIn[2][getSector(r, c)][k] = true;
				board[r][c] = k;
				
				dfs(nr, nc);

				board[r][c] = 0;
				isIn[0][r][k] = false;
				isIn[1][c][k] = false;
				isIn[2][getSector(r, c)][k] = false;
			}
		}
		
	}
	
	static int getSector(int r, int c) {
		int res = -1;
		
		if (r < 3) {
			if (c < 3)
				res = 0;
			else if (c >= 3 && c < 6)
				res = 1;
			else
				res = 2;
		} else if (r >= 3 && r < 6) {
			if (c < 3)
				res = 3;
			else if (c >= 3 && c < 6)
				res = 4;
			else
				res = 5;
		} else {
			if (c < 3)
				res = 6;
			else if (c >= 3 && c < 6)
				res = 7;
			else
				res = 8;
		}
		
		return res;
	}
}
