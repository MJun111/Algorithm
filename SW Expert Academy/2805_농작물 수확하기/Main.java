package com.ssafy.day0803.problem;

import java.util.*;
import java.io.*;

/*
 * N < 49, 홀수
 * N * N 크기 입력받아서 마름모꼴에 있는 농작물 총합
 * 
 */

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] farm = new int[n + 1][n + 1];
			
			for (int i = 1; i <= n; i++) {
				char[] c = br.readLine().toCharArray();
				for (int j = 1; j <= n; j++) {
					farm[i][j] = c[j - 1] - '0';
				}
			}
			
			int half = (n+1)/2;
			int sum = 0;
			for (int i = 1; i <= half; i++) {
				for (int j = 1; j <= n; j++) {
					if (j >= half - (i - 1) && j <= half + (i - 1))
						sum += farm[i][j];
				}
			}
			
			for (int i = half + 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (j >= half - (n - i) && j <= half + (n - i))
						sum += farm[i][j];
				}
			}
			
			
			System.out.println("#" + tc + " " + sum);
		}
		
	}
}
