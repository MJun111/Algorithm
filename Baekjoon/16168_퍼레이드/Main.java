import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] node;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int v, e, odd = 0;
        int[] degree;

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        node = new ArrayList[v + 1];
        degree = new int [v + 1];

        for (int i = 1; i <= v; i++)
            node[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a].add(b);
            node[b].add(a);
            degree[a]++;
            degree[b]++;
        }

        visited = new boolean[v + 1];
        boolean goBFS = false;
        for (int i = 1; i <= v; i++) {
            if (goBFS && !visited[i]) {
                sb.append("NO");
                System.out.println(sb);
                System.exit(0);
            }
            if (!visited[i]) {
                BFS(i);
                goBFS = true;
            }
        }

        for (int i = 1; i <= v; i++)
            if (degree[i] % 2 == 1)
                odd++;

        if (odd == 0 || odd == 2)
            sb.append("YES");
        else
            sb.append("NO");

        System.out.println(sb);
    }
    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            int n = q.poll();
            visited[n] = true;
            for (int num : node[n])
                if (!visited[num])
                    q.add(num);
        }
    }

}
