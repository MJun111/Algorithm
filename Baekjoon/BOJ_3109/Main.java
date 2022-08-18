import java.io.*;
import java.util.*;

public class Main {
	static int r, c, ans;
	static int[] dy = {1, 0, -1};	// 좌하, 좌, 좌상
	static int[] dx = {-1, -1, -1};
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// input
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		visited = new boolean[r][c];
		
		for (int i = 0; i < r; i++) 
			map[i] = br.readLine().toCharArray();
		
		
		// solve
		for (int i = r - 1; i >= 0; i--)
			dfs(i, c-1);
		
		System.out.println(ans);
	}
	
	// 원웅이 빵집 가장 아래행부터 다른 빵집까지, 좌하, 좌, 좌상 순으로 탐색
	static boolean dfs(int y, int x) {
		if (x == 0) {
			ans++;
			return true;
		}
		
		for (int i = 0; i < 3; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny < 0 || nx < 0 || ny >= r) continue;
			if (map[ny][nx] == 'x') continue;
			if (visited[ny][nx]) continue;
			visited[ny][nx] = true;
			
			if (dfs(ny, nx))
				return true;
		}
		return false;
	}
}
