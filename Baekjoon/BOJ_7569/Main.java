import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static int[][][] box;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 0, 1, 0, 0};
    static int[] dy = {0, -1, 0, 0, 1, 0};
    static int[] dh = {0, 0, -1, 0, 0, 1};

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
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int i = 0; i < H; i++)
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < H; i++)
            for (int j = 0; j < N; j++)
                for (int k = 0; k < M; k++)
                    if (box[i][j][k] == 1) {
                        q.add(i);
                        q.add(j);
                        q.add(k);
                        visited[i][j][k] = true;
                    }

        while (!q.isEmpty()) {
            int h = q.poll();
            int y = q.poll();
            int x = q.poll();

            for (int i = 0; i < 6; i++) {
                int nh = h + dh[i];
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (nh < 0 || ny < 0 || nx < 0 || nh >= H || ny >= N || nx >= M) continue;
                if (box[nh][ny][nx] != 0) continue;
                if (visited[nh][ny][nx]) continue;

                visited[nh][ny][nx] = true;
                box[nh][ny][nx] = box[h][y][x] + 1;
                q.add(nh);
                q.add(ny);
                q.add(nx);
            }
        }
    }

    static int getResult() {
        int ans = 0;
        for (int i = 0; i < H; i++)
            for (int j = 0; j < N; j++)
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0)
                        return -1;

                    ans = Math.max(ans, box[i][j][k] - 1);
                }
        return ans;
    }
}
