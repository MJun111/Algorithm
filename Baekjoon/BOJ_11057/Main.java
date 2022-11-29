import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MOD = 10007;
        int n = Integer.parseInt(br.readLine());
        long d[][] = new long [n + 1][11];

        for (int i = 0; i < 10; i++) {
            d[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    d[i][j] = (d[i][j] + d[i - 1][k]) % MOD;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans = (ans + d[n][i]) % MOD;
        }

        System.out.println(ans);
    }
}
