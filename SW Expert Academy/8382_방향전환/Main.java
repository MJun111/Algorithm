import java.io.*;
import java.util.*;

/*
메모리 : 90,284 kb
실행 시간 : 382 ms
코드 길이 : 2,579 B
 */

class Move {
    int y, x, cnt;
    boolean flag1;	// 세로 가능 여부
    boolean flag2;	// 가로 가능 여부

    Move(int y, int x, int cnt, boolean f1, boolean f2) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
        flag1 = f1;
        flag2 = f2;
    }
}

public class Main {
    static int x1, y1, x2, y2;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            int res = bfs();
            sb.append("#" + tc + " " + res + "\n");
        }
        System.out.print(sb);
    }

    static int bfs() {
        Queue<Move> q = new ArrayDeque<>();
        q.add(new Move(y1, x1, 0, true, true));

        // -100 ~ 100 범위를 표현하기 위해 + 100 하여 체크, 세로 가로 나눠서
        visited = new boolean[201][201][2];
        visited[y1 + 100][x1 + 100][0] = true;
        visited[y1 + 100][x1 + 100][1] = true;

        while(!q.isEmpty()) {
            int y = q.peek().y;
            int x = q.peek().x;
            int cnt = q.peek().cnt;
            boolean flag1 = q.peek().flag1;		// 세로 가능 여부
            boolean flag2 = q.poll().flag2;		// 가로 가능 여부

            if (y == y2 && x == x2)
                return cnt;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < -100 || nx < -100 || ny > 100 || nx > 100) continue;

                if (i < 2 && flag1) {
                    if (visited[ny + 100][nx + 100][0]) continue;
                    visited[ny + 100][nx + 100][0] = true;
                    q.add(new Move(ny, nx, cnt + 1, false, true));
                }

                if (i >= 2 && flag2) {
                    if (visited[ny + 100][nx + 100][1]) continue;
                    visited[ny + 100][nx + 100][1] = true;
                    q.add(new Move(ny, nx, cnt + 1, true, false));
                }
            }
        }
        return 0;
    }
}
