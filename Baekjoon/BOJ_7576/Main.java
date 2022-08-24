import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] box;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        bfs();
        sb.append(getResult());
        System.out.println(sb);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        visited = new boolean[N][M];
        	
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
				if (box[i][j] == 1) {
					q.add(i);
					q.add(j);
					visited[i][j] = true;
				}

        while (!q.isEmpty()) {
            int y = q.poll();
            int x = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if (box[ny][nx] != 0) continue;
                if (visited[ny][nx]) continue;

                visited[ny][nx] = true;
                box[ny][nx] = box[y][x] + 1;
                q.add(ny);
                q.add(nx);
            }
        }
    }

    static int getResult() {
        int ans = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
				if (box[i][j] == 0)
					return -1;

				ans = Math.max(ans, box[i][j] - 1);
				}
        return ans;
    }
}
