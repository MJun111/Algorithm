import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static char[][] map;
	static int[][] distW;
	static int[][] distH;
	static boolean[][] visited;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new char[R][];
        for (int i = 0; i < R; i++)
        	map[i] = br.readLine().toCharArray();
        
        bfsW();
        bfsH();
        
        for (int i = 0; i < R; i++)
        	for (int j = 0; j < C; j++)
        		if (map[i][j] == 'D') {
        			if (distH[i][j] == -1)
        				System.out.println("KAKTUS");
        			else
        				System.out.println(distH[i][j]);
        		}
	}

	static void bfsW() {
		visited = new boolean[R][C];
		distW = new int[R][C];
		for (int i = 0; i < R; i++)
			Arrays.fill(distW[i], -1);
		
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '*') {
					q.add(i);
					q.add(j);
					distW[i][j] = 0;
					visited[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int y = q.poll();
			int x = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
				if (map[ny][nx] == 'X' || map[ny][nx] == 'D') continue;
				if (visited[ny][nx]) continue;
				
				visited[ny][nx] = true;
				distW[ny][nx] = distW[y][x] + 1;
				q.add(ny);
				q.add(nx);
			}
		}
		
	}
	
	static void bfsH() {
		visited = new boolean[R][C];
		distH = new int[R][C];
		for (int i = 0; i < R; i++)
			Arrays.fill(distH[i], -1);
		
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					q.add(i);
					q.add(j);
					distH[i][j] = 0;
					visited[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int y = q.poll();
			int x = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
				if (map[ny][nx] == 'X') continue;
				if (distW[ny][nx] != -1 && distW[ny][nx] <= distH[y][x] + 1) continue;
				if (visited[ny][nx]) continue;
				
				visited[ny][nx] = true;
				distH[ny][nx] = distH[y][x] + 1;
				q.add(ny);
				q.add(nx);
			}
		}
	}
}
