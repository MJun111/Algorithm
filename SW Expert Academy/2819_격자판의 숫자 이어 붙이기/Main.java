import java.io.*;
import java.util.*;

/*
 * 메모리 : 87,652 kb
 * 실행 시간 : 243 ms
 * 코드 길이 : 1,286 
 */

public class SWEA_2819 {
	static int[][] map;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	static Set<String> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			map = new int[4][4];
			set = new HashSet<String>();
			
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++) {
					String tmp = map[i][j] + "";
					dfs(i, j, 0, tmp);
				}
			
			sb.append("#" + tc + " " + set.size() + "\n");
			set.clear();
		}
		System.out.print(sb);
	}
	
	static void dfs(int r, int c, int cnt, String str) {
		if (cnt == 6) {
			set.add(str);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dy[i];
			int nc = c + dx[i];
			
			if (nr < 0 || nc < 0 || nr >= 4 || nc >= 4) continue;
			str += map[nr][nc];
			dfs(nr, nc, cnt + 1, str);
			str = str.substring(0, str.length() - 1);
		}
		
	}
}
