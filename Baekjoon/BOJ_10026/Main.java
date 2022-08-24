import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static char[][] map;
	static boolean[][] visited;
	static boolean flag;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
		System.out.print(sb);
	}
	
	static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][];
        for (int i = 0; i < n; i++)
        	map[i] = br.readLine().toCharArray();
    }
	
	static void solve() {
		int cnt = 0;
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) 
				if (!visited[i][j]) {
					cnt++;
					bfs(i, j, map[i][j]);
				}
		
		sb.append(cnt + " ");
		
		cnt = 0;
		visited = new boolean[n][n];
		flag = true;
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) 
				if (!visited[i][j]) {
					cnt++;
					bfs(i, j, map[i][j]);
				}
		sb.append(cnt);
	}
	
	static void bfs(int r, int c, char color) {
		Queue<Integer> q = new ArrayDeque<>();
		visited[r][c] = true;
		q.add(r);
		q.add(c);
		
		while(!q.isEmpty()) {
			int y = q.poll();
			int x = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
				if (visited[ny][nx]) continue;
				if (!flag)
					if (map[ny][nx] != color) continue;
				if (flag) {
					if ((color == 'R' || color == 'G') && map[ny][nx] == 'B') continue;
					if (color == 'B' && (map[ny][nx] == 'R' || map[ny][nx] == 'G')) continue;
				}
				
				visited[ny][nx] = true;
				q.add(ny);
				q.add(nx);
			}
		}
	}
	
}
