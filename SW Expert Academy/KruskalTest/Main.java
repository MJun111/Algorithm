import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	static int[] parents;
	static int V, E;
	static Edge[] edgeList;
	
	static void make() { // 크기가 1인 서로 소 집합 생성

		parents = new int[V];
		for (int i = 0; i < V; i++) { // 모든 노드가 자신을 부모로 하는(대표자) 집합으로 만듦
			parents[i] = i;
		}
	}
	
	static int find(int a) { // a의 대표자 찾기
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) { // 리턴값 : true ==> union 성공
		a = find(a);
		b = find(b);
		
		if (a == b) return false;
		parents[a] = parents[b];
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/kruskal_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edgeList = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edgeList[i] = new Edge(
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken())
			);

		}
		make();
		Arrays.sort(edgeList);

		int res = 0;
		int cnt = 0;
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				res += edge.weight;
				if (++cnt == V - 1)
					break;
			}
		}
		System.out.println(res);
		
	}
}
