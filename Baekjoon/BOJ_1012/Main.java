import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Integer> q;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            visited = new boolean[n][m];
            q = new ArrayDeque<>();

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                map[b][a]++;
            }

            int ans = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        ans++;
                    }

            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int r, int c) {
        visited[r][c] = true;
        q.add(r);
        q.add(c);

        while (!q.isEmpty()) {
            int y = q.poll();
            int x = q.poll();

            for (int i = 0 ; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (map[ny][nx] == 0) continue;
                if (visited[ny][nx]) continue;

                visited[ny][nx] = true;
                q.add(ny);
                q.add(nx);
            }
        }
    }
}
