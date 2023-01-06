import java.util.*;
import java.io.*;
public class Main {
    static int w, h, ans;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new char[h][w];

        for (int i = 0; i < h; i++) {
            String str = br.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 'L')
                    bfs(i, j);
            }
        }

        System.out.println(ans);

    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    static void bfs(int a, int b) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(a);
        q.add(b);
        q.add(0);

        boolean[][] visited = new boolean[h][w];
        visited[a][b] = true;

        while(!q.isEmpty()) {
            int r = q.poll();
            int c = q.poll();
            int dist = q.poll();

            if (dist > ans) {
                ans = dist;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
                if (map[nr][nc] == 'W') continue;
                if (visited[nr][nc]) continue;

                visited[nr][nc] = true;
                q.add(nr);
                q.add(nc);
                q.add(dist + 1);
            }
        }
    }

}
