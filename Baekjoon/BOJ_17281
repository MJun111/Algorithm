import java.util.*;
import java.io.*;

// 1번째 타자는 4번타자 고정
// arr[n][0] -> Hitter[3] 순서 고정

public class Main {
    static int n;
    static int[][] arr;
    static ArrayList<ArrayList<Integer>> hitter = new ArrayList<>();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][9];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void setSequence() {
        int[] in = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] out = new int[9];
        boolean[] visited = new boolean[9];
        permu(in, out, visited, 0);
    }

    static void permu(int[] in, int[] out, boolean[] visited, int depth) {
        if(depth == 9) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < 9; i++)
                tmp.add(out[i]);
            hitter.add(tmp);
            return;
        }

        if (depth == 3) {
            out[depth] = 0;
            permu(in, out, visited, depth + 1);
        } else {
            for (int i = 0; i < 8; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    out[depth] = in[i];
                    permu(in, out, visited, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    static void playBall() {
        int ans = 0;
        for (int tc = 0; tc < hitter.size(); tc++) {
            int score = 0;      // 게임 점수
            int turn = 0;       // 타자 순서
            for (int ining = 0; ining < n; ining++) {
                int out = 0;
                boolean[] base = new boolean[3];        // 1, 2, 3루
                while (out < 3) {
                    int hitResult = arr[ining][hitter.get(tc).get(turn)];
                    if (hitResult == 0)
                        out++;
                    else if (hitResult == 1) {
                        if (base[2]) { base[2] = false; score++; }
                        if (base[1]) { base[1] = false; base[2] = true; }
                        if (base[0]) { base[1] = true; }
                        base[0] = true;
                    }
                    else if (hitResult == 2) {
                        if (base[2]) { base[2] = false; score++; }
                        if (base[1]) { base[1] = false; score++; }
                        if (base[0]) { base[0] = false; base[2] = true; }
                        base[1] = true;
                    }
                    else if (hitResult == 3) {
                        if (base[2]) { base[2] = false; score++; }
                        if (base[1]) { base[1] = false; score++; }
                        if (base[0]) { base[0] = false; score++; }
                        base[2] = true;
                    }
                    else {
                        if (base[2]) { base[2] = false; score++; }
                        if (base[1]) { base[1] = false; score++; }
                        if (base[0]) { base[0] = false; score++; }
                        score++;
                    }

                    turn = (turn + 1) % 9;
                }
            }
            ans = Math.max(ans, score);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        setSequence();
        playBall();
    }
}
