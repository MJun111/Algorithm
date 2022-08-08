import java.io.*;
import java.util.*;

class Pair {
    int y, x;
    Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Edge implements Comparable<Edge> {
    int v;
    int u;
    int length;

    Edge(int v, int u, int length) {
        this.v = v;
        this.u = u;
        this.length = length;
    }

    @Override
    public int compareTo(Edge e) {
        return this.length - e.length;
    }
}

public class Main {
    static int n, m;
    static int[][] map;
    static int[] parent;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static ArrayList<Pair>[] Island = new ArrayList[6];
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int islandCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1)
                    findIsland(i, j, islandCnt++);
            }
        }

        parent = new int[islandCnt];
        for (int i = 0; i < islandCnt; i++)
            parent[i] = i;

        for (int i = 0; i < islandCnt - 1; i++) {
            for (int j = i + 1; j < islandCnt; j++) {
                int length = findLength(Island[i], Island[j]);
                if (length != 101)
                    pq.add(new Edge(i, j, length));
            }
        }

        int ans = 0;
        while(!pq.isEmpty()) {
            Edge bridge = pq.poll();

            if(union(bridge.u, bridge.v))
                ans += bridge.length;

        }

        for (int i = 1; i < islandCnt; i++)
            if (union(i - 1, i))
                ans = -1;

        sb.append(ans);
        System.out.println(sb);
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

    static void findIsland(int r, int c, int islandCnt) {
        visited[r][c] = true;

        Island[islandCnt] = new ArrayList<>();
        Island[islandCnt].add(new Pair(r, c));

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));

        while(!q.isEmpty()) {
            int y = q.peek().y;
            int x = q.poll().x;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (map[ny][nx] == 0) continue;
                if (visited[ny][nx]) continue;

                visited[ny][nx] = true;
                q.add(new Pair(ny, nx));
                Island[islandCnt].add(new Pair(ny, nx));
            }
        }
    }

    static int findLength(ArrayList<Pair> l1, ArrayList<Pair> l2) {

        // 3 <= N * M <= 100
        int dist = 101;
        for (int i = 0; i < l1.size(); i++) {
            for (int j = 0; j < l2.size(); j++) {
                int x1 = l1.get(i).x;
                int y1 = l1.get(i).y;
                int x2 = l2.get(j).x;
                int y2 = l2.get(j).y;

                int tmp = 1;
                if (y1 == y2) {
                    if (x1 < x2) {
                        while (x1 + tmp < x2) {
                            if (map[y1][x1 + tmp] == 1) break;
                            tmp++;
                        }
                    } else {
                        while (x2 + tmp < x1) {
                            if (map[y1][x2 + tmp] == 1) break;
                            tmp++;
                        }
                    }
                    if (tmp == Math.abs(x2 - x1) && tmp - 1 >= 2)
                        dist = Math.min(dist, tmp - 1);
                }
                else if (x1 == x2) {
                    if (y1 < y2) {
                        while (y1 + tmp < y2) {
                            if (map[y1 + tmp][x1] == 1) break;
                            tmp++;
                        }
                    } else {
                        while (y2 + tmp < y1) {
                            if (map[y2 + tmp][x1] == 1) break;
                            tmp++;
                        }
                    }
                    if (tmp == Math.abs(y2 - y1) && tmp - 1 >= 2)
                        dist = Math.min(dist, tmp - 1);
                }
            }
        }

        return dist;
    }

}
