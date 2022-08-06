import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++)
            dq.add(i);

        sb.append("<");
        int cnt = 1;
        while(!dq.isEmpty()) {
            if (cnt++ % m == 0) {
                sb.append(dq.pollFirst());
                if (!dq.isEmpty())
                    sb.append(", ");
            } else {
                dq.addLast(dq.pollFirst());
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
