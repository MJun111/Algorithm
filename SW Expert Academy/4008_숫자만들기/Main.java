package com.ssafy.day1004.problem;

import java.io.*;
import java.util.*;

public class SWEA_4008_DFS {
	static int n, max, min;
	static int[] num;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/4008_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			num = new int[n];
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			int add = Integer.parseInt(st.nextToken());
			int sub = Integer.parseInt(st.nextToken());
			int mul = Integer.parseInt(st.nextToken());
			int div = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(num[0], 1, add, sub, mul, div);
			sb.append("#" + tc + " " + (max - min) + "\n");
		}
		System.out.print(sb);
	}
	
	// res : 이전 단계 계산 결과
	// cnt : 기저 조건을 확인하기 위한 재귀호출 cnt
	// add, sub, mul, div : 각 연산의 수행 가능 횟수
	static void dfs(int res, int cnt, int add, int sub, int mul, int div) {
		// 기저 조건
		if (cnt == n) {
			min = Math.min(min, res);
			max = Math.max(max, res);
			return;
		}
		
		if (add > 0)
			dfs(res + num[cnt], cnt + 1, add - 1, sub, mul, div);
		if (sub > 0)
			dfs(res - num[cnt], cnt + 1, add, sub - 1, mul, div);
		if (mul > 0)
			dfs(res * num[cnt], cnt + 1, add, sub, mul - 1, div);
		if (div > 0)
			dfs(res / num[cnt], cnt + 1, add, sub, mul, div - 1);
	}
}
