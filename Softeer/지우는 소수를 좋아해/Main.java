import java.util.*;
import java.io.*;


public class Main
{
    static class Node {
        int gym, level;

        public Node(int gym, int level) {
            this.gym = gym;
            this.level = level;
        }
    }

    static boolean[] isVisted;
    static List<Node>[] adjList;
    static int[] dist;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        isVisted = new boolean[n + 1];
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());      
            int c = Integer.parseInt(st.nextToken());

            adjList[a].add(new Node(b, c));
            adjList[b].add(new Node(a, c));
        }

        dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dijkstra(n, m);
    }

    public static void dijkstra(int n, int m) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.level, o2.level));
        pq.add(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int gym = cur.gym;

            for (int i = 0; i < adjList[gym].size(); i++) {
                int nextGym = adjList[gym].get(i).gym;
				int nextDist = Math.max(cur.level, adjList[gym].get(i).level);
				
				if (nextDist < dist[nextGym]) {
					dist[nextGym] = nextDist;
					pq.add(new Node(nextGym, nextDist));
				}
            }
        }

        System.out.println(findNextPrime(dist[n]));

    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int findNextPrime(int n) {
        while (true) {
            n++;
            if (isPrime(n)) {
                return n;
            }
        }
    }
}
