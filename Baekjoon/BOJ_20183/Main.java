import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int to;
    long cost, shame;

    Node(int to, long cost) {
        this.to = to;
        this.cost = cost;
    }

    Node(int to, long cost, long shame) {
        this.to = to;
        this.cost = cost;
        this.shame = shame;
    }

    @Override
    public int compareTo(Node o) {
        return Long.compare(this.shame, o.shame);
    }
}

public class Main {
    static int N, M, A, B;
    static long C;
    static ArrayList<Node>[] node;
    static long[] dist;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(dijkstra());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());

        dist = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = Long.MAX_VALUE;
        }

        node = new ArrayList[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (node[a] == null) node[a] = new ArrayList<>();
            if (node[b] == null) node[b] = new ArrayList<>();

            node[a].add(new Node(b, c));
            node[b].add(new Node(a, c));
        }
    }

    static long dijkstra() {
        dist[A] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(A, 0, 0));

        while(!pq.isEmpty()) {
            int cur = pq.peek().to;
            long cost = pq.peek().cost;
            long shame = pq.poll().shame;

            if (cur == B) return shame;
            if (dist[cur] < shame) continue;

            for (int i = 0; i < node[cur].size(); i++) {
                int next = node[cur].get(i).to;
                long nextCost = cost + node[cur].get(i).cost;
                long nextShame = Math.max(shame, node[cur].get(i).cost);

                if (nextCost <= C && dist[next] > nextShame) {
                    dist[next] = nextShame;
                    pq.add(new Node(next, nextCost, nextShame));
                }
            }
        }

        return -1;
    }
}
