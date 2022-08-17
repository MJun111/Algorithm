package com.ssafy.day0817.problem;

import java.io.*;
import java.util.*;

public class SWEA_5644 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/5644_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[] dy = {0, -1, 0, 1, 0};	// 이동안함, 상, 우, 하, 좌
		int[] dx = {0, 0, 1, 0, -1};
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			// input	
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			
			int[][] move = new int[2][M];
			
			// A 이동 경로
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) 
				move[0][i] = Integer.parseInt(st.nextToken());
			
			// B 이동 경로
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) 
				move[1][i] = Integer.parseInt(st.nextToken());
			
			// 각 배터리 별 맵 분포
			int[][][] map = new int[A][11][11];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int a, b, c, d;
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());
				
				map[i][b][a] = d;
				
				// 배터리 범위
				boolean[][] visited = new boolean[11][11];
				Queue<Integer> q = new ArrayDeque<>();
				q.add(b);
				q.add(a);
				q.add(0);
				while (true) {
					int y = q.poll();
					int x = q.poll();
					int cnt = q.poll();
					if (cnt >= c) break;
					
					for (int j = 1; j <= 4; j++) {
						int ny = y + dy[j];
						int nx = x + dx[j];
						
						if (ny <= 0 || nx <= 0 || ny > 10 || nx > 10) continue;
						if (visited[ny][nx]) continue;
						
						visited[ny][nx] = true;
						map[i][ny][nx] = d;
						q.add(ny);
						q.add(nx);
						q.add(cnt + 1);
					}
				}
				
			}
			
			// solve
			int sum = 0;
			int ay = 1, ax = 1, by = 10, bx = 10;
			for (int i = 0; i <= M; i++) {
				int tmpA = 0;
				int tmpB = 0;
				
				// 겹치는 부분 발생 시 비교를 위해 담아둠
				ArrayList<Integer> overlap = new ArrayList<>();
				
				// 배터리 충전
				for (int j = 0; j < A; j++) {
					if (map[j][ay][ax] != 0 && map[j][by][bx] != 0)
						overlap.add(j);
					else if (map[j][ay][ax] != 0)
						tmpA = Math.max(tmpA, map[j][ay][ax]);
					else if (map[j][by][bx] != 0)
						tmpB = Math.max(tmpB, map[j][by][bx]);
				}
				
				int tmpSum = tmpA + tmpB;
				
				// 겹쳤으면 이전 배터리 합과 비교
				for (int j = 0; j < overlap.size(); j++) {
					tmpSum = Math.max(tmpSum, tmpA + map[overlap.get(j)][by][bx]);
					tmpSum = Math.max(tmpSum, tmpB + map[overlap.get(j)][ay][ax]);
					tmpSum = Math.max(tmpSum, map[overlap.get(j)][ay][ax]); 
					
					tmpA = Math.max(tmpA, map[overlap.get(j)][ay][ax]);
					tmpB = Math.max(tmpB, map[overlap.get(j)][by][bx]);
				}
				sum += tmpSum;
				
				if (i == M) break;
				// 이동
				ay += dy[move[0][i]];
				ax += dx[move[0][i]];
				by += dy[move[1][i]];
				bx += dx[move[1][i]];
			}
			
			sb.append("#" + tc + " " + sum + "\n");
		}
		System.out.print(sb);
	}
	
}
