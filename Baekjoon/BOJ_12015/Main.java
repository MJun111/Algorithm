package com.ssafy.day1006.problem;

import java.io.*;
import java.util.*;

public class BOJ_12015 {
	static int n, ans;
	static int[] arr, lis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		binarySearch();
		System.out.println(ans);
	}
	
	static void binarySearch() {
		lis = new int[n + 1];
		int cnt = 0;
		lis[cnt++] = arr[0];
		
		for (int i = 1; i < n; i++) {
			// lis에 들어있는 최댓값보다 크다면 추가
			if (lis[cnt - 1] < arr[i]) {
				lis[cnt++] = arr[i];
			}
			// 최댓값보다 작다면 갱신시킬 위치 선정
			else {
				int start = 0;
				int end = cnt;
				
				while (start <= end) {
					int mid = (start + end) / 2;
					
					if (lis[mid] < arr[i]) {
						start = mid + 1;
					} else {
						end = mid - 1;
					}
				}
				
				// start < end 일 경우 start + 1, start <= end 일 경우 start
				lis[start] = arr[i];
			}
		}
		ans = cnt;
	}
}
