package com.ssafy.day0817.problem;

import java.io.*;
import java.util.*;

public class BOJ_1074 {
	static int N, r, c;
	static long totalCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		separate(0, 0, N);	
	}
	
	static void separate(long y, long x, long n) {
		if (n == 1) {
			for (long i = y; i <= y + 1; i++) {
				for (long j = x; j <= x + 1; j++) {
					if (i == r && j == c) {
						System.out.println(totalCnt);
					}
					else
						totalCnt++;
				}
			}
			return;
		}
		
		n--;
		long size = (long) Math.pow(2, n);
		long originSize = (long) Math.pow(2, n + 1);
		if (r >= y && r < y + size) {
			if (c >= x && c < x + size) {
				separate(y, x, n);
			}
			else {
				totalCnt += originSize * originSize / 4;
				separate(y, x + size, n);
			}
		}
		else {
			if (c >= x && c < x + size) {
				totalCnt += originSize * originSize * 2 / 4;
				separate(y + size, x, n);
			}
			else {
				totalCnt += originSize * originSize * 3 / 4;
				separate(y + size, x + size, n);
			}
		}
		
	}
	
}
