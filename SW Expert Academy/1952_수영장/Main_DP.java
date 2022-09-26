package com.ssafy.day0926.algo;

import java.io.*;
import java.util.*;

public class SWEA_1952_DP {
	
	static int T, feeDay, feeMonth, fee3Month, feeYear, min;
	static int[] plan = new int[13];
	static int[] dp = new int[13];
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/1952_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			feeDay = Integer.parseInt(st.nextToken());
			feeMonth = Integer.parseInt(st.nextToken());
			fee3Month = Integer.parseInt(st.nextToken());
			feeYear = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			min = feeYear;
			// dp
			dp[0] = 0;
			dp[1] = Math.min(plan[1] * feeDay, feeMonth);	// 일 계산과 월 계산 중 비용 적은 것 선택
			dp[2] = Math.min(dp[1] + plan[2] * feeDay, dp[1] + feeMonth);	// 누적
			
			for (int i = 3; i <= 12; i++) {
				dp[i] = min(
						dp[i - 1] + plan[i]* feeDay,
						dp[i - 1] + feeMonth,
						dp[i - 3] + fee3Month
					);
			}
			min = Math.min(min, dp[12]);
			sb.append("#" + tc + " " + min + "\n");
		}
		System.out.print(sb);
	}

	static int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}
}
