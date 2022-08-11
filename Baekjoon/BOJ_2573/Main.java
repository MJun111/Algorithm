import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {

        input();
        solution();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solution() {
        int year = 1;

        while(true) {
            melt();

            int chunk = getChunk();
            if (chunk == 0) {
                System.out.println(0);
                break;
            }
            else if (chunk > 1) {
                System.out.println(year);
                break;
            }
            year++;
        }
    }

    static void melt() {
        int[][] tmp = new int[n][];
        for (int i = 0; i < n; i++)
            tmp[i] = Arrays.copyOf(map[i], m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    for (int d = 0; d < 4; d++) {
                        int dr = i + dy[d];
                        int dc = j + dx[d];

                        if (dr < 0 || dc < 0 || dr >= n || dc >= m) continue;
                        if (map[dr][dc] != 0) continue;

                        tmp[i][j]--;
                    }
                    if (tmp[i][j] < 0)
                        tmp[i][j] = 0;
                }
            }
        }

        map = tmp;
    }

    static int getChunk() {
        int cnt = 0;
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static void bfs(int r, int c) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(r);
        q.add(c);

        while(!q.isEmpty()) {
            int nr = q.poll();
            int nc = q.poll();

            for (int i = 0; i < 4; i++) {
                int dr = nr + dy[i];
                int dc = nc + dx[i];

                if (dr < 0 || dc < 0 || dr >= n || dc >= m) continue;
                if (map[dr][dc] == 0) continue;
                if (visited[dr][dc]) continue;

                visited[dr][dc] = true;
                q.add(dr);
                q.add(dc);
            }
        }
    }
}
