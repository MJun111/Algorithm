import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int vertex, weight;

		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}	
	}
	
	static int V, E, K;
	static ArrayList<Node>[] adjList;
	static int[] dist;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		input();
		dijkstra();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++)
			adjList[i] = new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[u].add(new Node(v, w));
		}
		
		
		dist = new int[V + 1];
		for (int i = 1; i <= V; i++)
			dist[i] = Integer.MAX_VALUE;
	}
	
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		pq.add(new Node(K, 0));		// 시작위치, 가중치
		dist[K] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			// 인접한 구역을 돌며 비용 갱신여부 파악
			for (int i = 0; i < adjList[cur.vertex].size(); i++) {
				int next = adjList[cur.vertex].get(i).vertex;
				int nextDist = cur.weight + adjList[cur.vertex].get(i).weight;
				
				// 새로계산된 거리비용이 기존 거리비용보다 적다면 갱신 후 pq에 삽입
				if (nextDist < dist[next]) {
					dist[next] = nextDist;
					pq.add(new Node(next, nextDist));
				}
			}
		}
		
		for (int i = 1; i <= V; i++){
			if (dist[i] == Integer.MAX_VALUE)
				sb.append("INF\n");
			else
				sb.append(dist[i] + "\n");
		}
		System.out.print(sb);
	}
	
}
