import java.io.*;
import java.util.*;

/*
메모리 : 18,316 kb
실행 시간 : 108 ms
코드 길이 : 1,019 B
*/

public class Solution {
    static int x1, y1, x2, y2;
    public static void main(String[] args) throws IOException {
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

            int dy = Math.abs(y2 - y1);
            int dx = Math.abs(x2 - x1);
            int res = 0;

            if ((dy + dx) % 2 == 0)
                res = Math.max(dy, dx) * 2;
            else
                res = Math.max(dy, dx) * 2 - 1;

            sb.append("#" + tc + " " + res + "\n");
        }
        System.out.print(sb);
    }
}
