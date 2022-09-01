import java.io.*;
import java.util.*;

public class Main {
    static int F, S, G, U, D;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        input();
        bfs();

        System.out.println("use the stairs");
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F + 1];
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(S);
        q.add(0);
        visited[S] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            int cnt = q.poll();

            if (cur == G) {
                System.out.println(cnt);
                System.exit(0);
            }

            if (cur + U <= F && !visited[cur + U]) {
                visited[cur + U] = true;
                q.add(cur + U);
                q.add(cnt + 1);
            }

            if (cur - D > 0 && !visited[cur - D]) {
                visited[cur - D] = true;
                q.add(cur - D);
                q.add(cnt + 1);
            }
        }
    }
}
