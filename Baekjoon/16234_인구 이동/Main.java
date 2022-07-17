import java.util.*;
import java.io.*;

public class Main {
    static int n, l, r;
    static int[][] map;
    static boolean check;
    static boolean[][] visited;
    static int dir[][] = { {-1, 0, 1, 0}, {0, -1, 0, 1} };
    static ArrayList<Pair> list;

    static class Pair {
        int y, x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int bfs(int y, int x) {
        Queue<Pair> q = new LinkedList<>();
        list = new ArrayList<>();
        q.offer(new Pair(y, x));
        list.add(new Pair(y, x));
        visited[y][x] = true;
        int sum = map[y][x];

        while(!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dir[0][i];
                int ny = p.y + dir[1][i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                int size = Math.abs(map[p.y][p.x] - map[ny][nx]);
                if (size < l || size > r) continue;
                if (visited[ny][nx]) continue;

                visited[ny][nx] = true;
                q.offer(new Pair(ny, nx));
                list.add(new Pair(ny, nx));
                sum += map[ny][nx];

            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        while(true) {
            check = false;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        if (list.size() > 1) {
                            int avg = sum / list.size();
                            for (Pair p : list)
                                map[p.y][p.x] = avg;
                            check = true;
                        }
                    }
                }
            }
            if (!check)
                break;
            cnt++;
        }
        System.out.println(cnt);
    }
}
