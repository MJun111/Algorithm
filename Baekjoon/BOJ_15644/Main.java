import java.io.*;
import java.util.*;

class Bead {
   int ry, rx, by, bx, cnt;
   String path = "";

   Bead(int ry, int rx, int by, int bx, int cnt, String dir) {
       this.ry = ry;
       this.rx = rx;
       this.by = by;
       this.bx = bx;
       this.cnt = cnt;
       this.path = dir;
   }

}

public class Main {
    static int n, m, ans = 11;
    static String ansPath = "";
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dy = {-1, 0, 1, 0};    // 상, 좌, 하, 우
    static int[] dx = {0, -1, 0, 1};
    static Queue<Bead> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        input();
        bfs();

        if (ans == 11) ans = -1;
        sb.append(ans).append("\n").append(ansPath);
        System.out.print(sb);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][];
        visited = new boolean[n][m][n][m];

        // 0, 1 : R 구슬의 y, x     2, 3 : B 구슬의 y, x
        int[] bead = new int[4];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
            for (int j = 1; j < m - 1; j++) {
                if (map[i][j] == 'R') { bead[0] = i; bead[1] = j; }
                if (map[i][j] == 'B') { bead[2] = i; bead[3] = j; }
            }
        }
        visited[bead[0]][bead[1]][bead[2]][bead[3]] = true;
        q.add(new Bead(bead[0], bead[1], bead[2], bead[3], 0, ""));
    }

    static void bfs() {

        while(!q.isEmpty()) {
            Bead bead = q.poll();
            int move = bead.cnt;
            if (move >= 10) return;

            int ry = bead.ry;
            int rx = bead.rx;
            int by = bead.by;
            int bx = bead.bx;
            String path = bead.path;

            for (int i = 0; i < 4; i++) {
                int nry = ry;
                int nrx = rx;
                int nby = by;
                int nbx = bx;
                String dir = "";
                switch(i) {
                    case 0 : dir = "U"; break;
                    case 1 : dir = "L"; break;
                    case 2 : dir = "D"; break;
                    case 3 : dir = "R"; break;
                }

                // 구슬이 구멍에 빠지거나, 한 쪽 방향으로 벽에 다다를 때까지
                while(true) {
                    if (map[nry][nrx] != 'O' && map[nry][nrx] != '#') {
                        nry += dy[i];
                        nrx += dx[i];
                    }
                    if (map[nby][nbx] != 'O' && map[nby][nbx] != '#') {
                        nby += dy[i];
                        nbx += dx[i];
                    }

                    // 두 구슬 모두 벽에 다다랐을 때
                    if (map[nry][nrx] == '#' && map[nby][nbx] == '#') {
                        // 같은 좌표에 도달했다면 기존 위치와 비교하여 구슬 하나를 밀어냄
                        if (nry == nby && nrx == nbx) {
                            switch(i) {
                                case 0: if (ry > by) nry++; else nby++; break;      // 상, 좌, 하, 우
                                case 1: if (rx > bx) nrx++; else nbx++; break;
                                case 2: if (ry > by) nby--; else nry--; break;
                                case 3: if (rx > bx) nbx--; else nrx--; break;
                            }
                        }

                        if (!visited[nry - dy[i]][nrx - dx[i]][nby - dy[i]][nbx - dx[i]]) {
                            visited[nry - dy[i]][nrx - dx[i]][nby - dy[i]][nbx - dx[i]] = true;
                            q.add(new Bead(nry - dy[i], nrx - dx[i], nby - dy[i], nbx - dx[i], move + 1, path + dir));
                        }
                        break;
                    }
                    if (map[nry][nrx] == '#' && map[nby][nbx] == 'O') break;
                    if (map[nry][nrx] == 'O' && map[nby][nbx] == 'O') break;
                    if (map[nry][nrx] == 'O' && map[nby][nbx] == '#' ) {
                        ans = Math.min(ans, move + 1);
                        if (ansPath == "")
                            ansPath = path + dir;
                        break;
                    }
                }
            }
        }
    }
}
