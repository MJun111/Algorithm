package com.ssafy.day0802.problem;

import java.util.*;
import java.io.*;

public class SWEA_1208_Flatten {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());

			PriorityQueue<Integer> maxQ = new PriorityQueue<>();
			PriorityQueue<Integer> minQ = new PriorityQueue<>();
			int[] h = new int[101];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 100; i++) {
				h[i] = Integer.parseInt(st.nextToken());
				maxQ.add(-(h[i]));
				minQ.add(h[i]);
			}

			for (int i = 1; i <= n; i++) {
				int maxH = maxQ.poll();
				int minH = minQ.poll();
				
				maxQ.add(maxH + 1);
				minQ.add(minH + 1);
			}
			
			System.out.println("#" + tc + " " + ((-1) * maxQ.poll() - minQ.poll()) );
		}
		
	}
}
