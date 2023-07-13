import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        max = 0;
        int[] a = new int[n + 10];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        subset(a, m, 0, 0, 1);

        System.out.println(max);

    }

    public static void subset(int[] a, int m, int time, int idx, int size) {
        if (time == m) {
            max = Math.max(max, size);
            return;
        }

        if (idx <= n + 1) {
                subset(a, m, time + 1, idx + 1, size + a[idx + 1]);
            if (idx <= n + 2) {
                subset(a, m, time + 1, idx + 2, size / 2 + a[idx + 2]);
            }
        } else {
            max = Math.max(max, size);
        }
    }
}