import java.io.*;
import java.util.*;

public class Main {
    static int n, m, ans;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited = new boolean[n][m];
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
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solution() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, i, j, 1, map[i][j]);
                visited[i][j] = false;
            }
        System.out.println(ans);
    }

    static void dfs(int r, int c, int st_r, int st_c, int cnt, int sum) {
        if (cnt == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        if (cnt == 3)
            checkShapeF(r, c, st_r, st_c, sum);

        for (int i = 0; i < 4; i++) {
            int nr = r + dy[i];
            int nc = c + dx[i];

            if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
            if (visited[nr][nc]) continue;

            visited[nr][nc] = true;
            dfs(nr, nc, st_r, st_c,cnt + 1, sum + map[nr][nc]);
            visited[nr][nc] = false;
        }
    }
    
    // ㅗ 모양 체크
    static void checkShapeF(int r, int c, int st_r, int st_c, int sum) {
        if (r == st_r) {
            if (c > st_c) {
                if (r > 0)
                    ans = Math.max(ans, sum + map[r - 1][st_c + 1]);
                if (r < n - 1)
                    ans = Math.max(ans, sum + map[r + 1][st_c + 1]);
            }
            else {
                if (r > 0)
                    ans = Math.max(ans, sum + map[r - 1][st_c - 1]);
                if (r < n - 1)
                    ans = Math.max(ans, sum + map[r + 1][st_c - 1]);
            }
        }
        else if (c == st_c) {
            if (r > st_r) {
                if (c > 0)
                    ans = Math.max(ans, sum + map[st_r + 1][c - 1]);
                if (c < m - 1)
                    ans = Math.max(ans, sum + map[st_r + 1][c + 1]);
            }
            else {
                if (c > 0)
                    ans = Math.max(ans, sum + map[st_r - 1][c - 1]);
                if (c < m - 1)
                    ans = Math.max(ans, sum + map[st_r - 1][c + 1]);
            }
        }
        else
            return;
    }
}
