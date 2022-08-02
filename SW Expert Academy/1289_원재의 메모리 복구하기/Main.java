package com.ssafy.day0802.problem;

import java.io.*;
import java.util.*;

public class SWEA_1289_원재의메모리복구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			String origin = br.readLine();
			sb = new StringBuilder();

			int len = origin.length();
			// 초기화된 메모리 생성
			for (int i = 0; i < len; i++)
				sb.append("0");
			String order = sb.toString();
			
			// idx : 순차적으로 비교할 index, cnt : 바꾸는 횟수
			int idx = 0;
			int cnt = 0;
			while(idx < len) {
				int c = order.charAt(idx); 
				// 인덱스 비교를 하며 원본 메모리와 다를 경우
				if ((int)origin.charAt(idx) != c) {
					// 앞전까지의 원본 메모리를 모두 복사한 후
					String tmp = origin.substring(0, idx);
					sb = new StringBuilder();
					
					// 뒷 부분은 반전 (0이었으면 1, 1이었으면 0)
					for (int i = idx; i < len; i++)
						sb.append(((c - '0') + 1) % 2);
					
					tmp += sb.toString();
					order = tmp;
						
					cnt++;
				}
				idx++;
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
