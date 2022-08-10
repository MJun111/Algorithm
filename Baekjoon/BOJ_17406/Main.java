import java.io.*;
import java.util.*;

// 명령 순서 r, c, s 저장할 클래스
class Seq {
    int r, c, s;
    Seq(int r, int c, int s) {
        this.r = r;
        this.c = c;
        this.s = s;
    }
}

public class Main {
    static int n, m, k, ans = Integer.MAX_VALUE;
    static Seq[] seq;
    static int[][] origin_arr;      // 원본을 가지고 있을 배열
    static int[][] arr;             // 움직이는 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m + 1];
        origin_arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                origin_arr[i][j] = arr[i][j];
            }
        }

        seq = new Seq[k + 1];
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            seq[i] = new Seq(r, c, s);
        }

        permu(new int[k + 1], new boolean[k + 1], 1);
        System.out.println(ans);

    }

    // 순열로 나온 경우의 수대로 회전 시행
    static void permu(int[] out, boolean[] visited, int depth) {
        if (depth == k + 1) {
            for (int i = 1; i <= k; i++) {
                rotate(out[i]);
            }
            findMin();
            restoreArray();
            return;
        }

        for (int i = 1; i <= k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = i;
                permu(out, visited, depth + 1);
                visited[i] = false;
            }
        }
    }

    // 최솟값 탐색
    static void findMin() {
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= m; j++) {
                sum += arr[i][j];
            }
            ans = Math.min(ans, sum);
        }
    }

    // 원래 배열로 복구
    static void restoreArray() {
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                arr[i][j] = origin_arr[i][j];
    }

    static void rotate(int idx) {
        int r = seq[idx].r;
        int c = seq[idx].c;
        int s = seq[idx].s;

        int st_r = r - s;
        int end_r = r + s;
        int st_c = c - s;
        int end_c = c + s;

        int cnt = 0;
        while (true) {
            // 중앙 좌표로부터 s만큼 떨어져있으므로 s번 시행하면 회전 1싸이클
            if (cnt >= s) break;

            // 꼭짓점 좌표
            int[] vertex = { arr[st_r][end_c], arr[end_r][st_c], arr[end_r][end_c] };

            // 오른쪽
            for (int i = end_c; i > st_c; i--)
                arr[st_r][i] = arr[st_r][i - 1];

            // 아래
            for (int i = end_r; i > st_r; i--)
                arr[i][end_c] = arr[i - 1][end_c];
            arr[st_r + 1][end_c] = vertex[0];

            // 왼쪽
            for (int i = st_c; i < end_c - 1; i++)
                arr[end_r][i] = arr[end_r][i + 1];
            arr[end_r][end_c - 1] = vertex[2];

            // 위
            for (int i = st_r; i < end_r - 1; i++)
                arr[i][st_c] = arr[i + 1][st_c];
            arr[end_r - 1][st_c] = vertex[1];

            st_r++;
            st_c++;
            end_r--;
            end_c--;
            cnt++;
        }
    }
}
