package com.ssafy.day1007.problem;

import java.io.*;
import java.util.*;

public class BOJ_17471 {
	
	static int n, ans = Integer.MAX_VALUE, tmp;
	static int[] popu;
	static List<Integer>[] node;
	static List<Integer> A, B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		popu = new int[n];
		node = new ArrayList[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			popu[i] = Integer.parseInt(st.nextToken());
			node[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < m; j++) {
				node[i].add(Integer.parseInt(st.nextToken()) - 1);
			}
		}
		
		subset(0, new boolean[n]);
		
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		
		System.out.println(ans);
	}
	
	static void subset(int cnt, boolean[] isSelected) {
		if (cnt == n) {
			A = new ArrayList<>();
			B = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (isSelected[i]) 
					A.add(i);
				else
					B.add(i);
			}
			
			if (A.size() != 0 && B.size() != 0) {
				if (isValid()) {
					ans = Math.min(ans, tmp);
				}
			}
			
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt + 1, isSelected);
		
		isSelected[cnt] = false;
		subset(cnt + 1, isSelected);
		
	}
	
	static boolean isValid() {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] checked = new boolean[n];
		
		int cur = A.get(0);
		q.add(cur);
		checked[cur] = true;
		int aSum = popu[cur];
		while (!q.isEmpty()) {
			cur = q.poll();
			
			for (int i = 0; i < node[cur].size(); i++) {
				int next = node[cur].get(i);
				
				if (checked[next]) continue;
				if (!A.contains(next)) continue;
				
				checked[next] = true;
				aSum += popu[next];
				q.add(next);
			}
		}
		
		cur = B.get(0);
		q.add(cur);
		checked[cur] = true;
		int bSum = popu[cur];
		while (!q.isEmpty()) {
			cur = q.poll();
			
			for (int i = 0; i < node[cur].size(); i++) {
				int next = node[cur].get(i);
				
				if (checked[next]) continue;
				if (!B.contains(next)) continue;
				
				checked[next] = true;
				bSum += popu[next];
				q.add(next);
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (!checked[i])
				return false;
		}
		
		tmp = Math.abs(aSum - bSum);
		
		return true;
	}
	
}
