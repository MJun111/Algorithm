import java.io.*;
import java.util.*;

/*
- 상어 처음 크기 : 2
- 1초에 상하좌우 인접한 칸으로 이동
- 상어 몸집 > 먹이 몸집인 경우 먹을 수 있음
- 상어 몸집 < 먹이 몸집인 경우 이동할 수 없음
- 거리가 가까운 순으로 먹음
- 가까운 먹이가 여러개라면 위쪽, 왼쪽 부터 차례대로
- 상어 몸집 수 만큼 먹이를 먹으면 상어 몸집 + 1
- 종료조건 : 더 이상 먹을 수 있는 먹이가 없음 -> 물고기 0 or 먹이의 몸집이 모두 같거나 클 경우 or 먹을 수 있는 먹이가 먹을 수 없는 먹이에 가로막혀있어 갈 수 없는 경우 -> ex
ex)
1 5
5 3(상어)     -> 위 경우 1 물고기를 먹을 수 있지만 5 물고기를 지나갈 수 없어 종료
 */

class Pair implements Comparable<Pair> {
    int r, c;

    Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public int compareTo(Pair f) {
        if (this.r == f.r)
            return this.c - f.c;

        return this.r - f.r;
    }
}

public class Main {
    static int n, body = 2, sizeUp, cnt, ans;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static ArrayList<Pair> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        move();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    visited[i][j] = true;
                    list.add(new Pair(i, j));
                    map[i][j] = 0;
                }
            }
        }
    }

    static void move() {
        while(!list.isEmpty()) {
            Collections.sort(list);
            boolean isEat = false;
            int lSize = list.size();

            for (int d = 0; d < lSize; d++) {
                Pair cur = list.remove(0);
                int y = cur.r;
                int x = cur.c;

                // 먹이 발견
                if (map[y][x] != 0 && map[y][x] < body) {
                    map[y][x] = 0;
                    sizeUp++;

                    if (body == sizeUp) {
                        body++;
                        sizeUp = 0;
                    }
                    list.clear();
                    visited = new boolean[n][n];
                    visited[y][x] = true;
                    ans = cnt;
                    isEat = true;
                }

                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                    if (map[ny][nx] > body) continue;
                    if (visited[ny][nx]) continue;

                    visited[ny][nx] = true;
                    list.add(new Pair(ny, nx));
                }

                if (isEat)
                    break;
            }
            cnt++;
        }
        System.out.println(ans);
    }
}
