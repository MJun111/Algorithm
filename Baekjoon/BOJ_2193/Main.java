import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long d[] = new long [n + 1];

        d[0] = 0;
        d[1] = 1;

        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 2] + d[i - 1];
        }

        System.out.println(d[n]);
    }
}
