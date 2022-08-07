import java.io.*;
import java.util.*;

public class Main {
    static int x1, y1, x2, y2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int ix, iy;

            int[] ans = new int[3];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                ix = Integer.parseInt(st.nextToken());
                iy = Integer.parseInt(st.nextToken());

                int res = checkDot(ix, iy);
                ans[res]++;
            }
            System.out.println("#" + tc + " " + ans[0] + " " + ans[1] + " " + ans[2]);
        }
    }
    static int checkDot(int x, int y) {
        if (y > y1 && y < y2) {
            if (x > x1 && x < x2)
                return 0;
            else if (x == x1 || x == x2)
                return 1;
        }
        else if (y == y1 || y == y2) {
            if (x >= x1 && x <= x2)
                return 1;
        }
        return 2;
    }
}
