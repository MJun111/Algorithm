package com.ssafy.day0804.problem;

import java.io.*;
import java.util.*;

public class SWEA_1225_암호생성기 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/1225_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			int tcNum = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			Queue<Integer> q = new LinkedList<>();
			
			for (int i = 0; i < 8; i++) 
				q.add(Integer.parseInt(st.nextToken()));
			
			int decrease = 1;
			while(true) {
				int num = q.poll();
				num -= decrease;
				
				if (num <= 0) {
					num = 0;
					q.add(num);
					break;
				}
				
				q.add(num);
				decrease = (decrease % 5) + 1;
			}
			
			
			System.out.print("#" + tcNum + " ");
			while(!q.isEmpty())
				System.out.print(q.poll() + " ");
			System.out.println();
		}
		
	}
}
