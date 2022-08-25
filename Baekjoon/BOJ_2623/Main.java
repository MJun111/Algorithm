import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] adjList;
	static int[] inDegree;
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++)
			adjList[i] = new ArrayList<>();
		
		inDegree = new int[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int nums = Integer.parseInt(st.nextToken());
			int tmp = 0;
			for (int j = 0; j < nums; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (tmp != 0) {
					adjList[tmp].add(a);
					++inDegree[a];
				}
				tmp = a;
			}
		}	
	}
	
	static void solve() {
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> orderList = topologySort();
		if(orderList.size() == N) {
			for (int o : orderList) 
				sb.append(o).append("\n");
			
			System.out.print(sb);
		}
		else 
			System.out.println("0");
		
	}
	
	static ArrayList<Integer> topologySort() {
		ArrayList<Integer> orderList = new ArrayList<>();
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		for (int i = 1; i <= N; ++i) 
			if(inDegree[i] == 0) q.add(i);
		
		 
		while(!q.isEmpty()) {
			int cur = q.poll();
			orderList.add(cur);
			for (int idx : adjList[cur]) {
				if(--inDegree[idx] == 0) q.add(idx);
			}
		}
		return orderList;
	}
}
