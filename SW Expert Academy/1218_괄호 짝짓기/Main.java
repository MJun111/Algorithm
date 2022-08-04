package com.ssafy.day0804.problem;

import java.io.*;
import java.util.*;

public class SWEA_1218_괄호짝짓기 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/1218_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
		// default ans는 통과 상태
		int ans = 1;
		int n = Integer.parseInt(br.readLine());
		
		// 괄호 내용 char 배열로 받아온 후 한 자리 씩 비교
		char[] c;
		c = br.readLine().toCharArray();
		
		Stack<Integer> st = new Stack<>();
		
		// 괄호 종류를 숫자로 관리 ex ) '(' = 0, '{' = 2, ')' = 4 ...
		String bracket = "([{<)]}>";
		int kind = 0;
		st.add(bracket.indexOf(c[0]));
		
		for (int i = 1; i < n; i++) {
			kind = bracket.indexOf(c[i]);
			
			// 열린 괄호라면 스택에 삽입
			if (kind < 4) 
				st.add(kind);
			
			// 닫힌 괄호인 경우 스택의 최상단에 들어있는 열린괄호와 짝이 맞는지 확인
			else {
				if (st.peek() == kind - 4)
					st.pop();
				else {
					ans = 0;
					break;
				}
			}
		}
		
		System.out.println("#" + tc + " " + ans);
		}
	}
}
