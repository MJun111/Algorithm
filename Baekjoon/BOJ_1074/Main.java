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
	
	static void separate(int y, int x, int n) {
		if (n == 0) {
			System.out.println(totalCnt);
			return;
		}
		
		n--;
		int size = (int) Math.pow(2, n);
		if (r >= y && r < y + size) {
			if (c >= x && c < x + size) {
				separate(y, x, n);
			}
			else {
				totalCnt += size * size;
				separate(y, x + size, n);
			}
		}
		else {
			if (c >= x && c < x + size) {
				totalCnt +=	size * size * 2;
				separate(y + size, x, n);
			}
			else {
				totalCnt += size * size * 3;
				separate(y + size, x + size, n);
			}
		}
		
	}
	
}
