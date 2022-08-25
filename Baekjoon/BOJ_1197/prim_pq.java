package com.ssafy.day0825.problem;

import java.io.*;
import java.util.*;

class Vertex implements Comparable<Vertex>{
	int vertex, weight;

	public Vertex(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}

	@Override
	public int compareTo(Vertex v) {
		return Integer.compare(this.weight, v.weight);
	}
}

public class BOJ_1197_pqPrim {
	static int V, E;
	static ArrayList<Vertex>[] adjList;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		input();
		pqPrim();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++)
			adjList[i] = new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from].add(new Vertex(to, weight));
			adjList[to].add(new Vertex(from, weight));
		}
	}
	
	static void pqPrim() {
		int ans = 0;
		visited = new boolean[V + 1];
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.add(new Vertex(1, 0));	// 시작 정점 1, 가중치 0
		
		while(!pq.isEmpty()) {
			Vertex cur = pq.poll();
			
			if (visited[cur.vertex]) continue;
			visited[cur.vertex] = true;
			
			ans += cur.weight;
			
			for (Vertex v : adjList[cur.vertex]) {
				if (!visited[v.vertex]) {
					pq.add(v);
				}
			}
		}
		System.out.println(ans);
	}
	
}
