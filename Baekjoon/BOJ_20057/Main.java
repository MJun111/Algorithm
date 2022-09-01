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

            if(--move == 0) {
                dir = (dir + 1) % 4;
                if (dir == 2 || dir == 0)
                    cnt++;
                move = cnt;
            }
            setSand(r, c);

            if (r == 0 && c == 0) {
                break;
            }
        }

        System.out.println(ans);
    }

    static void setSand(int r, int c) {
        // y, x, % 순서
        int[][] dir = {
                {-2, 0, 2}, {-1, -1, 10}, {-1, 0, 7}, {-1, 1, 1},
                {0, -2, 5}, {1, -1, 10}, {1, 0, 7}, {1, 1, 1}, {2, 0, 2}
        };
        int amount = map[r][c];

        for (int i = 0; i < 9; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            int percent = dir[i][2];
            int sand = (int)Math.floor((double)map[r][c] * percent / 100);
            if (amount * percent / 100 > (double)sand) {
                amount -= sand - 1;
            }
            else {
                amount -= sand;
            }

//            int sand = map[r][c] * percent / 100;
//            amount -= sand;

            if (nr < 0 || nc < 0 || nr >= n || nc >= n)
                ans += sand;
            else
                map[nr][nc] += sand;
        }

        // 알파 좌표 : r, c - 1
        if (c - 1 >= 0)
            map[r][c - 1] += amount;
        else
            ans += amount;

        map[r][c] = 0;

        System.out.println("===========Test==============");
        System.out.println(r + ", " + c);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("ans : " + ans);

    }

}
