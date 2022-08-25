package com.ssafy.day0825.problem;

import java.io.*;
import java.util.*;

class Edge {
	int from, to, weight;

	public Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}

public class BOJ_1197_kruskal {
	static int V, E;
	static int[] p;
	static ArrayList<Edge> edgeList;
	
	public static void main(String[] args) throws IOException {
		input();
		kruskal();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		p = new int[V + 1];
		for (int i = 1; i <= V; i++)
			p[i] = i;
		
		edgeList = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList.add(new Edge(from, to, weight));
		}
	}
	
	static void kruskal() {
		Collections.sort(edgeList, (o1, o2) -> Integer.compare(o1.weight, o2.weight));
		
		int ans = 0;
		for (Edge edge : edgeList) {
			if (find(edge.from) != find(edge.to)) {
				union(edge.from, edge.to);
				ans += edge.weight;
			}
		}
		System.out.println(ans);
	}
	
	static int find(int a) {
		if (p[a] == a) return a;
		return p[a] = find(p[a]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		p[b] = a;
	}
	
}
