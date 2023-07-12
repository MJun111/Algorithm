import java.io.*;
import java.util.*;

public class Main {
    static int t, n, m;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] cost = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                cost[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            cost[x][y] = c;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (cost[i][j] > cost[i][k] + cost[k][j]) {
                        cost[i][j] = cost[i][k] + cost[k][j];
                    }
                }
            }
        }

        int res = INF;

        // 서로 가는 경로가 있다면 사이클 존재
        for (int i = 1; i <= n; i++) {
            if (cost[i][i] != INF) {
                res = Math.min(res, cost[i][i]);
                continue;
            }

            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (cost[i][j] != INF && cost[j][i] != INF) {
                    res = Math.min(res, cost[i][j] + cost[j][i]);
                }
            }
        }

        if (res == INF) res = -1;
        System.out.print(res);
    }
}