import java.io.*;
import java.util.*;

class Move {
	int y, x, cnt;
	boolean flag1;	// 세로 가능 여부
	boolean flag2;	// 가로 가능 여부

	Move(int y, int x, int cnt, boolean f1, boolean f2) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
		flag1 = f1;
		flag2 = f2;
	}
}

public class SWEA_8382 {
	static int x1, y1, x2, y2;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/8382_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			int res = bfs();
			sb.append("#" + tc + " " + res + "\n");
		}
		System.out.print(sb);
	}

	static int bfs() {
		Queue<Move> q = new ArrayDeque<>();
		q.add(new Move(y1, x1, 0, true, true));
		
		// -100 ~ 100 범위를 표현하기 위해 + 100 하여 체크
		visited = new boolean[201][201];
		visited[y1 + 100][x1 + 100] = true;
		
		while(!q.isEmpty()) {
			int y = q.peek().y;
			int x = q.peek().x;
			int cnt = q.peek().cnt;
			boolean flag1 = q.peek().flag1;		// 세로 가능 여부
			boolean flag2 = q.peek().flag2;		// 가로 가능 여부
			
			if (y == y2 && x == x2) {
				return cnt;
			}
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (ny < -100 || nx < -100 || ny > 100 || nx > 100) continue;
				if (visited[ny + 100][nx + 100]) continue;
				if (i < 2 && flag1) {
					visited[ny + 100][nx + 100] = true;
					q.add(new Move(ny, nx, cnt + 1, !flag1, flag2));
				}
				if (i >= 2 && flag2) {
					visited[ny + 100][nx + 100] = true;
					q.add(new Move(ny, nx, cnt + 1, flag1, !flag2));
				}
				
			}
		}
		return 0;
	}
}
