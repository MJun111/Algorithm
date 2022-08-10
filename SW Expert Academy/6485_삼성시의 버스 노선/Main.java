package com.ssafy.day0809.problem;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/6485_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			
			// A, B 입력
			int[] A = new int[n];
			int[] B = new int[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				A[i] = Integer.parseInt(st.nextToken());
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			int p = Integer.parseInt(br.readLine());
			int[] C = new int[p];
			
			// C 입력
			for (int i = 0; i < p; i++) 
				C[i] = Integer.parseInt(br.readLine());
			
			// 버스 노선 체크
			int[] busStop = new int[5001];
			for (int i = 0; i < n; i++)
				for (int j = A[i]; j <= B[i]; j++) 
					busStop[j]++;
			
			// 버스 정류장 카운트
			for (int i = 0; i < p; i++) 
				sb.append(busStop[C[i]]).append(" ");
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
