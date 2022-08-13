import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int ans = 26;
    static int[] cp = {0, 5, 5, 5, 5, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        map = new int[11][11];

        for (int i = 1; i <= 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        ans = ans == 26 ? -1 : ans;
        sb.append(ans);
        System.out.println(sb);
    }

    // cnt : 색종이를 붙인 횟수
    static void dfs(int cnt) {
        // 기저 조건
        if (ans < cnt) return;

        // 색종이를 모두 붙였다면 ans값 갱신
        if (isPaste(1, 1, 10, 1)) {
            ans = Math.min(ans, cnt);
            return;
        }

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                // 1 발견 시 색종이 붙일 수 있는지 판단
                if (map[i][j] == 1) {
                    for (int size = 5; size > 0; size--) {
                        // size 크기의 색종이가 남아있고, 범위를 빠져나가지 않으며, 붙일 수 있는 공간이 있으면 붙이고 진행 후 떼봄
                        if (cp[size] > 0 && checkRange(i + size - 1, j + size - 1) && isPaste(i, j, size, 0)) {
                            cp[size]--;
                            pastePaper(i, j, size, 0);

                            dfs(cnt + 1);

                            cp[size]++;
                            pastePaper(i, j, size, 1);
                        }
                    }
                    // 모든 사이즈의 색종이를 붙여봤으면 return
                    return;
                }
            }
        }
    }

    // map[i][j] == fill : 0 -> 색종이를 붙일 수 없음, 1 -> 색종이 붙일 수 있음
    static boolean isPaste(int r, int c, int size, int fill) {
        for (int i = r; i < r + size; i++)
            for (int j = c; j < c + size; j++)
                if (map[i][j] == fill)
                    return false;
        return true;
    }

    // map[i][j] = paper : 0 -> 색종이를 붙임, 1 -> 색종이를 뗌
    static void pastePaper(int r, int c, int size, int paper) {
        for (int i = r; i < r + size; i++)
            for (int j = c; j < c + size; j++)
                map[i][j] = paper;
    }

    static boolean checkRange(int r, int c) {
        if (r > 10 || c > 10) return false;
        return true;
    }
}
