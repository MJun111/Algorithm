package com.ssafy.day0825.problem;

import java.io.*;
import java.util.*;

class Node {
	int vertex, weight;
	Node next;
	
	public Node(int vertex, int weight, Node next) {
		this.vertex = vertex;
		this.weight = weight;
		this.next = next;
	}
}

public class BOJ_1197_prim {
	static int V, E;
	static Node[] adjList;
	static int[] minEdge;
	static boolean[] visited;
	
	
	public static void main(String[] args) throws IOException {
		input();
		prim();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new Node[V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
		
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}
	}
	
	static void prim() {
		int[] minEdge = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		minEdge[1] = 0;
		int ans = 0;	
		
		for (int c = 1; c <= V; c++) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for (int i = 1; i <= V; i++) {
				if (!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			
			visited[minVertex] = true;
			ans += min;
			
			for (Node temp = adjList[minVertex]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
					minEdge[temp.vertex] = temp.weight;
				}
			}
			
		}
		System.out.println(ans);
	}
	
}
