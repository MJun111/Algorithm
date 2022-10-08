package com.ssafy.day1007.problem;

import java.io.*;
import java.util.*;

/*
 * 1. 기준점 (x, y)와 경계의 길이 d1, d2를 정한다. (d1, d2 ≥ 1, 1 ≤ x < x+d1+d2 ≤ N, 1 ≤ y-d1 < y < y+d2 ≤ N)
 * 2. 다음 칸은 경계선이다.
 * 	1) (x, y), (x+1, y-1), ..., (x+d1, y-d1)
	2) (x, y), (x+1, y+1), ..., (x+d2, y+d2)
	3) (x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
	4) (x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
 * 3. 경계선과 경계선의 안에 포함되어있는 곳은 5번 선거구이다.
 * 4. 5번 선거구에 포함되지 않은 구역 (r, c)의 선거구 번호는 다음 기준을 따른다.
 * 	- 1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
	- 2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N
	- 3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
	- 4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
 * 
 * 
 */

public class BOJ_17779 {
	static int n, ans = 987654321;
	static int[][] A;
	static boolean[][][][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		A = new int[n + 1][n + 1];
		visited = new boolean[n + 1][n + 1][n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 초기 가능한 값부터 시작
		makeBoundary(1, 2, 1, 1);
		System.out.println(ans);
	}
	
	static void makeBoundary(int x, int y, int d1, int d2) {
		if (!visited[x][y][d1][d2])
			makeDistrict(x, y, d1, d2);
		
		if (!visited[x + 1][y][d1][d2] && x + d1 + d2 + 1 <= n) {
			makeBoundary(x + 1, y, d1, d2);
		}
		if (!visited[x][y][d1 + 1][d2] && x + d1 + d2 + 1 <= n && y - (d1 + 1) < y) {
			makeBoundary(x, y, d1 + 1, d2);			
		}
		if (!visited[x][y][d1][d2 + 1] && x + d1 + d2 + 1 <= n && y + d2 + 1 <= n) {
			makeBoundary(x, y, d1, d2 + 1);
		}
		if (!visited[x][y + 1][d1][d2] && y + d2 + 1 <= n) {
			makeBoundary(x, y + 1, d1, d2);			
		}
	}

	static void makeDistrict(int x, int y, int d1, int d2) {
		visited[x][y][d1][d2] = true;
		int[] sum = new int[6];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				// 1번 선거구
				if (i < x + d1 && j <= y && !(i >= x && j >= y - (i - x))) {
					sum[1] += A[i][j];
				}
				// 2번 선거구
				else if (i <= x + d2 && j > y && !(i >= x && j <= y + (i - x))) {
					sum[2] += A[i][j];
				}
				// 3번 선거구
				else if (i >= x + d1 && j < y - d1 + d2 && !(i <= x + d1 + d2 && j >= (y - d1 + d2 - (x + d1 + d2 - i)))) {
					sum[3] += A[i][j];
				}
				// 4번 선거구
				else if (i > x + d2 && j >= y - d1 + d2 && !(i <= x + d1 + d2 && j <= (y - d1 + d2 + (x + d1 + d2 - i)))) {
					sum[4] += A[i][j];
				}
				// 5번 선거구
				else {
					sum[5] += A[i][j];
				}
			}
		}
		
		for (int i = 1; i <= 5; i++) {
			max = Math.max(max, sum[i]);
			min = Math.min(min, sum[i]);
		}
		
		ans = Math.min(ans, max - min);
	}
	
}
