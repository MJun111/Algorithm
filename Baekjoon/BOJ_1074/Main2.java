package com.ssafy.day0817.problem;

import java.io.*;
import java.util.*;

public class BOJ_1074_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int size = (int)Math.pow(2, N) / 2;
		int ans = 0;
		
		while (N-- > 0) {
			int skip = 3;
			if (r < size && c < size) skip = 0;
			else if (r < size && c >= size) skip = 1;
			else if (r >= size && c < size) skip = 2;
			
			ans += size * size * skip;
			r %= size;
			c %= size;
			size = (int)Math.pow(2, N) / 2;
		}
		
		System.out.println(ans);
	}
}
