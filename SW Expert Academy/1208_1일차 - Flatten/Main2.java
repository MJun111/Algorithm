package com.ssafy.day0802.problem;

import java.io.*;
import java.util.*;

public class SWEA_1208_Flatten2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/1208_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			int N = sc.nextInt();
			int[] box = new int[101];
			int minH = 100, maxH = 1;
			
			for (int i = 0; i < 100; i++) {
				int h = sc.nextInt();
				box[h]++;
				maxH = maxH < h ? h : maxH;
				minH = minH > h ? h : minH;
			}
			
			while (N > 0 && (maxH - minH) > 1) {
				box[maxH]--;
				box[minH]--;
				
				box[maxH - 1]++;
				box[minH + 1]++;
				
				if (box[maxH] == 0) maxH--;
				if (box[minH] == 0) minH++;
				
				N--;
			}
			
			ans = maxH - minH;
			System.out.println("#" + t + " " + ans);
		}
		
		sc.close();
	}
}
