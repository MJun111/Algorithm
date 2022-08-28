import java.io.*;
import java.util.*;

public class Main {
    static int n, l, ans;
    static int[][] map;
    static boolean[][] incline;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    static void solve() {

        incline = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            checkRow(i);
        }

        incline = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            checkCol(i);
        }
        System.out.println(ans);
    }

    static void checkRow(int row) {
        int value = map[row][0];
        for (int i = 1; i < n; i++) {
            if (value != map[row][i]) {
                if (Math.abs(value - map[row][i]) > 1) return;

                // 올라가는 경사로
                if (value < map[row][i]) {
                    if (i - l < 0) return;

                    for (int j = i - l; j < i; j++) {
                        if (!incline[row][j] && map[row][j] == value) {
                            incline[row][j] = true;
                        }
                        else return;
                    }

                    value++;
                }
                // 내려가는 경사로
                else {
                    if (i + l > n) return;

                    for (int j = i; j < i + l; j++) {
                        if (!incline[row][j] && map[row][j] == value - 1) {
                            incline[row][j] = true;
                        }
                        else return;
                    }
                    i += l - 1;
                    value--;
                }
            }

        }
        ans++;
    }

    static void checkCol(int col) {
        int value = map[0][col];
        for (int i = 1; i < n; i++) {
            if (value != map[i][col]) {
                if (Math.abs(value - map[i][col]) > 1) return;

                // 올라가는 경사로
                if (value < map[i][col]) {
                    if (i - l < 0) return;

                    for (int j = i - l; j < i; j++) {
                        if (!incline[j][col] && map[j][col] == value) {
                            incline[j][col] = true;
                        }
                        else return;
                    }

                    value++;
                }
                // 내려가는 경사로
                else {
                    if (i + l > n) return;

                    for (int j = i; j < i + l; j++) {
                        if (!incline[j][col] && map[j][col] == value - 1) {
                            incline[j][col] = true;
                        }
                        else return;
                    }
                    i += l - 1;
                    value--;
                }
            }

        }
        ans++;
    }

}
