import java.io.*;
import java.util.*;

/*
메모리 : 31,188 kb
실행 시간 : 161 ms
코드 길이 : 1,831
 */

public class Main {
    static int n, ans;
    static int[][] cafe;
    static boolean[] visited;
    static int[] dr = {-1, 1, 1, -1, 0};
    static int[] dc = {-1, -1, 1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {

            n = Integer.parseInt(br.readLine());
            cafe = new int[n][n];
            visited = new boolean[101];
            ans = -1;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    cafe[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            search();
            sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    static void search() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, i, j, 1, 0);
            }
        }
    }

    // 한 방향을 정했다가 바꾸면 이 전 방향은 사용할 수 없음
    static void dfs(int stR, int stC, int r, int c, int cnt, int dir) {
        if (dir == 4) return;
        if (r < 0 || c < 0 || r >= n || c >= n) return;
        if (cnt != 1 && stR == r && stC == c) {
            ans = Math.max(ans, cnt - 1);
            return;
        }

        if (visited[cafe[r][c]]) return;

        visited[cafe[r][c]] = true;
        dfs(stR, stC, r + dr[dir], c + dc[dir], cnt + 1, dir);
        dir++;
        dfs(stR, stC, r + dr[dir], c + dc[dir], cnt + 1, dir);
        visited[cafe[r][c]] = false;
    }
}
