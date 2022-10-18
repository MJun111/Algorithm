import java.io.*;
import java.util.*;

public class Main {
    static class Computer implements Comparable<Computer>{
        int link, sec;
        public Computer(int link, int sec) {
            this.link = link;
            this.sec = sec;
        }

        @Override
        public int compareTo(Computer o) {
            return this.sec - o.sec;
        }
    }
    static final int MAX = 987654321;
    static int n, d, c;
    static List<Computer>[] list;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            dist = new int[n + 1];
            Arrays.fill(dist, MAX);

            list = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

//                if(list[b] == null) list[b] = new ArrayList<>();
                list[b].add(new Computer(a, s));
            }

            dijkstra();
            int cnt = 0, totalTime = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] != MAX) {
                    cnt++;
                    totalTime = Math.max(totalTime, dist[i]);
                }
            }
            sb.append(cnt + " " + totalTime + "\n");
        }
        System.out.print(sb);
    }

    static void dijkstra() {
        PriorityQueue<Computer> pq = new PriorityQueue<>();
        pq.add(new Computer(c, 0));
        dist[c] = 0;

        while (!pq.isEmpty()) {
            Computer cur = pq.poll();

            if (dist[cur.link] < cur.sec) continue;

            for (int i = 0; i < list[cur.link].size(); i++) {
                int time = dist[cur.link] + list[cur.link].get(i).sec;

                if (time < dist[list[cur.link].get(i).link]) {
                    dist[list[cur.link].get(i).link] = time;
                    pq.add(new Computer(list[cur.link].get(i).link, time));
                }
            }
        }
    }
}
