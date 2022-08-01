import java.util.*;
import java.io.*;

public class Main {
    static int r, c;
    static int[][] apples;
    static int[][] bananas;
    static int[][] a_sum;       // 불도저가 r, c를 지날 때 해당 열에서 A 나라가 얻을 수 있는 사과의 개수
    static int[][] b_sum;       // 불도저가 r, c를 지날 때 해당 열에서 B 나라가 얻을 수 있는 바나나의 개수
    static int[][] dp;          // 불도저가 r, c를 지날 때 얻을 수 있는 총합의 최대

    public static void main(String[] args) throws IOException {
        input();
        getSum_a();
        getSum_b();
        getDP();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        apples = new int[r + 1][c + 1];
        bananas = new int[r + 1][c + 1];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                String tmp = st.nextToken();
                if (tmp.charAt(0) == 'A')
                    apples[i][j] = Integer.parseInt(tmp.substring(1));
                else if (tmp.charAt(0) == 'B')
                    bananas[i][j] = Integer.parseInt(tmp.substring(1));
            }
        }
    }

    static void getSum_a() {
        a_sum = new int[r + 1][c + 1];
        for (int j = 0; j < c; j++)
            for (int i = r - 1; i > 0; i--)
                a_sum[i - 1][j] = a_sum[i][j] + apples[i][j];
    }

    static void getSum_b() {
        b_sum = new int[r + 1][c + 1];
        for (int j = 1; j < c; j++)
            for (int i = 0; i < r; i++)
                b_sum[i + 1][j] = b_sum[i][j] + bananas[i][j];
    }

    static void getDP() {
        dp = new int[r + 1][c + 1];
        // 시작지에서 아래로만 가는 경우
        for (int i = 0; i < r; i++)
            dp[i][0] = a_sum[i][0];

        for (int j = 1; j < c; j++) {
            for (int i = 0; i < r; i++) {
                // 시작지에서 오른쪽으로만 갈 경우
                if (i == 0)
                    dp[i][j] = dp[i][j - 1] + a_sum[i][j];
                else {
                    dp[i][j] = Math.max(
                            Math.max(
                                    dp[i][j - 1] + a_sum[i][j] + b_sum[i][j],        // 오른쪽
                                    dp[i - 1][j - 1] + a_sum[i][j] + b_sum[i][j]     // 오른쪽 아래
                            ), dp[i - 1][j] - apples[i][j]                           // 아래
                    );
                }
            }
        }

        System.out.println(dp[r - 1][c - 1]);
    }
}
