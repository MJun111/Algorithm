import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println((int)Math.pow(2,n) - 1);
        hanoi(n, 1, 2, 3);

        System.out.println(sb);
    }

    static void hanoi(int n, int st, int tmp, int end) {
        if (n == 1) {
            sb.append(st + " " + end + "\n");
            return;
        }
        hanoi(n - 1, st, end, tmp);
        sb.append(st + " " + end + "\n");
        hanoi(n - 1, tmp, st, end);
    }
}
