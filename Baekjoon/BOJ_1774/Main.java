import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int v;
    int u;
    double weight;

    Edge(int v, int u, double weight) {
        this.v = v;
        this.u = u;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e) {
        return Double.compare(this.weight, e.weight);
    }
}

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 우주신[좌표 x, y][idx]
        int[][] spaceGod = new int[2][n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            spaceGod[0][i] = Integer.parseInt(st.nextToken());
            spaceGod[1][i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            union(v, u);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int x1 = spaceGod[0][i];
                int y1 = spaceGod[1][i];
                int x2 = spaceGod[0][j];
                int y2 = spaceGod[1][j];

                double weight = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

                pq.add(new Edge(i, j, weight));
            }
        }

        double ans = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();

            if(union(edge.u, edge.v)) {
                ans += edge.weight;
            }
        }
        System.out.printf("%.2f", ans);
    }

    static int find(int a) {
        if (parent[a] == a)
            return a;
        return find(parent[a]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[a] = b;
            return true;
        }
        return false;
    }
}
