import java.io.*;
import java.util.*;

/*
신맛 : 사용한 재료의 신맛의 곱
쓴맛 : 사용한 재료의 쓴맛의 합
재료 >= 1
 */

public class Main {
    static long[][] food;
    static long ans = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        food = new long[2][n];       // 0 : 신맛, 1 : 쓴맛
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            food[0][i] = Long.parseLong(st.nextToken());
            food[1][i] = Long.parseLong(st.nextToken());
        }

        subset(0, n, 0);
        sb.append(ans);
        System.out.println(sb);
    }

    static void subset(int cnt, int n, int flag) {
        if (cnt == n) {
            if (flag == Math.pow(2, n) - 1) return;
            long sour = 1;
            long bitter = 0;

            for (int i = 0; i < n; i++) {
                if ((flag & 1 << i) == 0) {
                    sour *= food[0][i];
                    bitter += food[1][i];
                }
            }

            ans = Math.min(ans, Math.abs(sour - bitter));
            return;
        }

        subset(cnt + 1, n, flag | 1 << cnt);
        subset(cnt + 1, n, flag);
    }
}
