import java.io.*;
import java.util.*;

public class Main {
    static int n, ans;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        input();
        goTornado();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void goTornado() {
        int r = n / 2;
        int c = n / 2;
        int cnt = 1;
        int move = 1;
        int dir = 0; // 0 : 왼쪽, 1: 아래, 2 : 오른쪽, 3 : 위
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while(true) {
            r += dy[dir];
            c += dx[dir];
            setSand(dir,r, c);

            if(--move == 0) {
                dir = (dir + 1) % 4;
                if (dir == 2 || dir == 0)
                    cnt++;
                move = cnt;
            }

            if (r == 0 && c == 0) {
                break;
            }
        }

        System.out.println(ans);
    }

    static void setSand(int d, int r, int c) {
        // dir, y, x, % 순서
        int[][][] dir = {
                {{-2, 0, 2}, {-1, -1, 10}, {-1, 0, 7}, {-1, 1, 1}, {0, -2, 5}, {1, -1, 10}, {1, 0, 7}, {1, 1, 1}, {2, 0, 2}, {0, -1, 0}},
                {{0, -2, 2}, {1, -1, 10}, {0, -1, 7}, {-1, -1, 1}, {2, 0, 5}, {1, 1, 10}, {0, 1, 7}, {-1, 1, 1}, {0, 2, 2}, {1, 0, 0}},
                {{-2, 0, 2}, {-1, 1, 10}, {-1, 0, 7}, {-1, -1, 1}, {0, 2, 5}, {1, 1, 10}, {1, 0, 7}, {1, -1, 1}, {2, 0, 2}, {0, 1, 0}},
                {{0, -2, 2}, {-1, -1, 10}, {0, -1, 7}, {1, -1, 1}, {-2, 0, 5}, {-1, 1, 10}, {0, 1, 7}, {1, 1, 1}, {0, 2, 2}, {-1, 0, 0}}
        };
        int amount = map[r][c];

        for (int i = 0; i < 9; i++) {
            int nr = r + dir[d][i][0];
            int nc = c + dir[d][i][1];
            int percent = dir[d][i][2];

            int sand = map[r][c] * percent / 100;
            amount -= sand;

            if (nr < 0 || nc < 0 || nr >= n || nc >= n)
                ans += sand;
            else
                map[nr][nc] += sand;
        }

        // 마지막 알파 처리
        int nr = r + dir[d][9][0];
        int nc = c + dir[d][9][1];
        if (nr < 0 || nc < 0 || nr >= n || nc >= n)
            ans += amount;
        else
            map[nr][nc] += amount;

        map[r][c] = 0;
    }
}
