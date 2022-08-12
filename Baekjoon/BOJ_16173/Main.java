import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] map;
	static boolean[][] visited;
    public static void main(String[] args) throws IOException {
    	input();
    	bfs();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < n; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }	
    }
    
    static void bfs() {
    	if (map[0][0] >= n) {
    		System.out.println("Hing");
    		return;
    	}
    	
    	Queue<Integer> q = new ArrayDeque<>();
    	q.add(0);
    	q.add(0);
    	visited[0][0] = true;
    	
    	int[] dr = {1, 0};
    	int[] dc = {0, 1};
    	
    	while (!q.isEmpty()) {
    		int r = q.poll();
    		int c = q.poll();
    		
    		for (int i = 0; i < 2; i++) {
    			int nr = r + dr[i] * map[r][c];
    			int nc = c + dc[i] * map[r][c];
    			
    			if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
    			if (visited[nr][nc]) continue;
    			if (map[nr][nc] == -1) {
    				System.out.println("HaruHaru");
    				return;
    			}
    			visited[nr][nc] = true;
    			q.add(nr);
    			q.add(nc);
    		}
    	}
    	
    	System.out.println("Hing");
    }

}
