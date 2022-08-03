package com.ssafy.day0803.problem;

import java.io.*;
import java.util.*;

public class BOJ_11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = arr[i - 1][j] + Integer.parseInt(st.nextToken());
			}
		}
			
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			for (int r = y1; r <= y2; r++) {
				sum += arr[r][x2] - arr[r][x1 - 1];
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}
