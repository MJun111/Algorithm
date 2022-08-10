package com.ssafy.day0809.problem;

import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] A;
	static int[] check;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/1861_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			n = Integer.parseInt(br.readLine());
			
			A = new int[n + 1][n + 1];
			
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					A[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			check = new int[n * n + 1];
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						
						if (nr <= 0 || nc <= 0 || nr > n || nc > n) continue;
						if (A[i][j] + 1 == A[nr][nc]) {
							check[A[i][j]]++;
							break;
						}
					}
				}
			}

			int minRoom = 1000, maxMove = 0;
			int move = 1;
			for (int i = n * n; i > 0; i--) {
				if (check[i] == 0) {
					move = 1;
					continue;
				}
				move++;
				if (maxMove <= move) {
					maxMove = move;
					minRoom = i;
				}
			}
			
			sb.append(minRoom).append(" ").append(maxMove).append("\n");
		}
		System.out.print(sb);
	}
}
