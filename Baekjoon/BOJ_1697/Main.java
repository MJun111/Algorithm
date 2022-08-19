import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static final int MAX = 100000;
	static boolean[] visited = new boolean[MAX + 1];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		bfs();
	}
	
	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(n);
		q.add(0);
		visited[n] = true;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			int time = q.poll();
			
			if (x == k) {
				System.out.println(time);
				break;
			}
			
			if (x + 1 <= MAX && !visited[x + 1]) {
				visited[x + 1] = true;
				q.add(x + 1);
				q.add(time + 1);
			}
			if (2 * x <= MAX && !visited[2 * x]) {
				visited[2 * x] = true;
				q.add(2 * x);
				q.add(time + 1);
			}

			if (x - 1 >= 0 && !visited[x - 1]) {
				visited[x - 1] = true;
				q.add(x - 1);
				q.add(time + 1);
			}
			
		}
	}
}
