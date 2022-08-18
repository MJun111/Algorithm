import java.io.*;
import java.util.*;

public class Main {
	static int r, c, ans;
	static char[][] map;
	static boolean[] visited = new boolean[26];
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		for (int i = 0; i < r; i++)
			map[i] = br.readLine().toCharArray();
			
		visited[map[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		System.out.println(ans);
	}
	
	static void dfs(int y, int x, int cnt) {
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny < 0 || nx < 0 || ny >= r || nx >= c) { ans = Math.max(ans, cnt); continue; }
			if (visited[map[ny][nx] - 'A']) { ans = Math.max(ans, cnt); continue; }
			
			visited[map[ny][nx] - 'A'] = true;
			dfs(ny, nx, cnt + 1);
			visited[map[ny][nx] - 'A'] = false;
		}
	}
	
}
