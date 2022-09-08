import java.io.*;
import java.util.*;

public class SWEA_5653 {
	static class Cell implements Comparable<Cell>{
		int y, x, life, birth;
		
		Cell(int y, int x, int life, int birth) {
			this.y = y;
			this.x = x;
			this.life = life;
			this.birth = birth;
		}

		@Override
		public int compareTo(Cell c) {
			return c.life - this.life;
		}
	}
	
	static int n, m, k;
	static boolean[][] visited;
	static Queue<Cell> q;
	static PriorityQueue<Cell> pq;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			sb.append("#" + tc + " ");
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			visited = new boolean[n + k + 1][m + k + 1];
			q = new ArrayDeque<>();
			pq = new PriorityQueue<>();
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					int life = Integer.parseInt(st.nextToken());
					
					if (life > 0) {
						int r = k/2 + i;
						int c = k/2 + j;
						
						visited[r][c] = true;
						q.add(new Cell(r, c, life, 0));
					}
				}
			}
			
			for (int i = 1; i <= k; i++)
				bfs(i);
			
			sb.append(q.size() + "\n");
		}
		System.out.print(sb);
	}
	
	static void bfs(int time) {
		
		int size = q.size();
		for (int i = 0; i < size; i++) {
			Cell c = q.poll();
			
			// 세포 비활성화
			if (time <= c.birth + c.life) {
				q.add(c);
			}
			// 세포 활성화 후 1시간 뒤 => 세포 번식
			else if (time == c.birth + c.life + 1) {
				pq.add(c);
			}
			// 세포 번식 후 활성화
			else if (time < c.birth + 2 * c.life) {
				q.add(c);
			}
		}
		
		
		while(!pq.isEmpty()) {
			Cell c = pq.poll();
			
			if (time < c.birth + 2 * c.life) 
				q.add(c);
			
			for (int i = 0; i < 4; i++) {
				int ny = c.y + dy[i];
				int nx = c.x + dx[i];
				
				if (visited[ny][nx]) continue;
				
				visited[ny][nx] = true;
				q.add(new Cell(ny, nx, c.life, time));
			}
		}
	}
}
