package com.ssafy.day0926.algo;

import java.io.*;
import java.util.*;

public class SWEA_1952_DFS {

	static int T, feeDay, feeMonth, fee3Month, feeYear, min;
	static int[] plan = new int[12];

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
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			// 완탐 dfs, 1년치 제외한 3가지 사용료 모두 따지는 방식으로 min 갱신
			// dfs() 이후 min이 가장 작은 값이 들어감
			min = feeYear;
			dfs(0, 0); // 최초, 비용 0
			sb.append("#" + tc + " " + min + "\n");
		}
		System.out.print(sb);
	}

	// 재귀 호출방식 => 파라미터로 어떤 값을 가지고 계속 이어갈 것 인가?
	static void dfs(int cnt, int sum) {
		// 기저 조건
		if (cnt >= 12) {
			min = Math.min(min, sum);
			return;
		}
		
		 if (plan[cnt] == 0) {
	         dfs(cnt + 1, sum);
	      } else {
	         // 1. 일 계산
	         int cost = plan[cnt] * feeDay;
	         if (sum + cost < min) {
	            dfs(cnt + 1, sum + cost);
	         }
	         if (sum + feeMonth < min) {
	            dfs(cnt + 1, sum + feeMonth);
	         }
	         if (sum + fee3Month < min) {
	            // 3. 3개월 계산
	            dfs(cnt + 3, sum + fee3Month);
	         }
	      }

	}

}
