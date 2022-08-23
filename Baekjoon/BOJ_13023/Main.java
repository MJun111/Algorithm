import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] vertex;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        input();

    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        vertex = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (vertex[a] == null) vertex[a] = new ArrayList<>();
            if (vertex[b] == null) vertex[b] = new ArrayList<>();
            vertex[a].add(b);
            vertex[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            if (vertex[i] == null) continue;
            visited[i] = true;
            dfs(i, 0);
            visited[i] = false;
        }
        System.out.println("0");
    }

    static void dfs(int cur, int cnt) {
        if (cnt == 4) {
            System.out.println("1");
            System.exit(0);
        }

        for (int i = 0; i < vertex[cur].size(); i++) {
            int next = vertex[cur].get(i);
            if (visited[next]) continue;
            visited[next] = true;
            dfs(next, cnt + 1);
            visited[next] = false;
        }
    }
}
