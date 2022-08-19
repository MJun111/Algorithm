import java.io.*;
import java.util.*;

/*
* 메모리 : 25,612 kb
* 실행 시간 : 139 ms
* 코드 길이 : 1,402
*/

public class SWEA_1227 {
	static int stY, stX;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/1227_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());
			sb.append("#" + tc + " ");
			
			map = new int[100][100];
			visited = new boolean[100][100];
			for (int i = 0; i < 100; i++) {
				char[] tmp = br.readLine().toCharArray();
				for (int j = 0; j < 100; j++) {
					map[i][j] = tmp[j] - '0';
					
					if (map[i][j] == 2) {
						stY = i; stX = j;
					}
				}
			}
			
			sb.append(bfs() + "\n");
		}
		System.out.print(sb);
	}
	
	static int bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(stY);
		q.add(stX);
		visited[stY][stX] = true;
		
		while(!q.isEmpty()) {
			int y = q.poll();
			int x = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (ny < 0 || nx < 0 || ny >= 100 || nx >= 100) continue;
				if (map[ny][nx] == 1) continue;
				if (visited[ny][nx]) continue;
				
				if (map[ny][nx] == 3) return 1;
				
				visited[ny][nx] = true;
				q.add(ny);
				q.add(nx);
				
			}
			
		}
		return 0;
	}
}
