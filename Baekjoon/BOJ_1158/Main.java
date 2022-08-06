import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            q.add(i);

        sb.append("<");
        int cnt = 1;
        while(!q.isEmpty()) {
            int num = q.poll();

            if (cnt++ % m == 0) {
                sb.append(num);

                if (!q.isEmpty())
                    sb.append(", ");

                continue;
            }
            q.add(num);
        }
        sb.append(">");
        System.out.println(sb);
    }
}
