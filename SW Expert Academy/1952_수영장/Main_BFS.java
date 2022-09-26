package com.ssafy.day0926.algo;

import java.io.*;
import java.util.*;

public class SWEA_1952_BFS {
	static class Node {
		int cnt, sum;
		public Node(int cnt, int sum) {
			this.cnt = cnt;
			this.sum = sum;
		}
	}
	
	static int T, feeDay, feeMonth, fee3Month, feeYear, min;
	static int[] plan = new int[12];
	static Queue<Node> q = new ArrayDeque<>();
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

			// 완탐 bfs
			// 최초 시점의 Node 를 하나 queue에 담고 시작
			min = feeYear;
			q.add(new Node(0, 0));
			bfs();
			sb.append("#" + tc + " " + min + "\n");
		}
		System.out.print(sb);
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			Node node = q.poll();
			int cnt = node.cnt;
			int sum = node.sum;
			
			if (cnt >= 12) {
				min = Math.min(min, sum);
				continue;
			}
			
			// 이용하지 않는 경우
			if (plan[cnt] == 0) {
				q.add(new Node(cnt + 1, sum));
			} else {
				// 1. 일 계산
				int cost = plan[cnt] * feeDay;
				if (sum + cost < min)
					q.add(new Node(cnt + 1, sum + cost));
				
				// 2. 월 계산
				if (sum + feeMonth < min)
					q.add(new Node(cnt + 1, sum + feeMonth));
				
				// 3. 3개월 계산
				if (sum + fee3Month < min)
					q.add(new Node(cnt + 3, sum + fee3Month));
			}
			
		}
		
	}

}
