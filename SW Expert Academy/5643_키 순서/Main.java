import java.io.*;
import java.util.*;

public class Solution {
	static int n, m, adj[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			adj = new int[n + 1][n + 1];

			for (int i = 1; i <= n; i++) adj[i][0] = -1;	// 탐색하지 않은 상태의 초기값
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a][b] = 1;	// a보다 b가 키가 크다
			}

			int ans = 0;
			for (int i = 1; i <= n; i++) {
				if (adj[i][0] == -1) dfs(i, adj);
			}
			// 모든 정점이 알고있는 관계로 탐색을 마친 상태 (큰 정점을 따라 탐색해서 간접관계를 직접관계로 다 반영해서 인접행렬 update)
			// 열 기준 정보를 확인하면 자신보다 작은 정점을 파악 가능
			
			for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
					adj[0][k] += adj[i][k];
				}
			}
			
			for (int k = 1; k <= n; k++) {
				if (adj[k][0] + adj[0][k] == n - 1) ans++;
			}
			
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.print(sb);
	}
	
	static void dfs(int cur, int[][] adj) { // cur 학생보다 키가 큰 학생따라 탐색
		
		for (int i = 1; i <= n; i++) { // 자신의 인접행렬 들여다보기
			if (adj[cur][i] == 1) {
				if (adj[i][0] == -1) dfs(i, adj);
				
				// 나보다 큰 정점의 탐색 정보를 메모
				if (adj[i][0] > 0) { // i보다 큰 정점이 존재 : cur < i < j 를 만족하는 j 존재 ==> cur < j 상태로 메모
					for (int j = 1; j <= n; j++) {
						if (adj[i][j] == 1) adj[cur][j] = 1;
					}
				}
			}
		}
		// 자신보다 큰 정점의 탐색을 모두 완료 메모하기
		int cnt = 0;
		for (int k = 1; k <= n; k++) cnt += adj[cur][k]; // 1의 개수만큼 더해짐
		
		adj[cur][0] = cnt;
	}
	
	
}
