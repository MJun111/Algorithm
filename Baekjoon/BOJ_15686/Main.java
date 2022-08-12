package com.ssafy.day0812.problem;

import java.io.*;
import java.util.*;

public class BOJ_15686 {
	static int n, m;
	static int[][] map;
	static ArrayList<int[]> home = new ArrayList<>();
	static ArrayList<int[]> chicken = new ArrayList<>();
	static int[] seq;
	static int ansDist = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int [n][n];
        
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < n; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if (map[i][j] == 1)
        			home.add(new int[]{i, j});
        		if (map[i][j] == 2)
        			chicken.add(new int[] {i, j});
        	}
        }
        
        seq = new int[chicken.size()];
        
        for (int i = 1; i <= m; i++) {
        	combi(0, 0, i);
        }
        System.out.println(ansDist);
	}
	
	static void combi(int start, int cnt, int max) {
		if (cnt == max) {
			findDist(cnt);
			return;
		}
		
		for (int i = start; i < chicken.size(); i++) {
			seq[cnt] = i;
			combi(i + 1, cnt + 1, max);
		}
		
	}
	
	static void findDist(int size) {
		int chickenDist = 0;
		for (int i = 0; i < home.size(); i++) {
			int dist = Integer.MAX_VALUE;
			for (int j = 0; j < size; j++) {
				int[] h = home.get(i);
				int[] c = chicken.get(seq[j]);
				dist = Math.min(dist, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
			}
			chickenDist += dist;
		}
		ansDist = Math.min(ansDist, chickenDist);
	}
}
