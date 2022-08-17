import java.io.*;
import java.util.*;

class Pair {
    int a, b;
    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Main {
    static int N, K, L, time;
    static int dir;
    static int[][] map;
    static Queue<Pair> q = new ArrayDeque<>();
    static int[] dy = {0, 1, 0, -1};    // 우, 하, 좌, 상
    static int[] dx = {1, 0, -1, 0};    // D : + 1, L : + 3
    public static void main(String[] args) throws IOException {
        input();
        play();
        System.out.println(time);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            if (c == 'D')
                q.add(new Pair(t, 1));
            else
                q.add(new Pair(t, 3));
        }
    }

    static void play() {
        ArrayDeque<Pair> dq = new ArrayDeque<>();
        dq.add(new Pair(1, 1));
        boolean[][] isExist = new boolean[N + 1][N + 1];
        isExist[1][1] = true;
        while(true) {
            time++;
            int hy = dq.peekLast().a + dy[dir];
            int hx = dq.peekLast().b + dx[dir];

            if (hy <= 0 || hx <= 0 || hy > N || hx > N) break;
            if (isExist[hy][hx]) break;
            isExist[hy][hx] = true;

            dq.add(new Pair(hy, hx));
            if (map[hy][hx] == 1) {
                map[hy][hx] = 0;
            }
            else {
                int ty = dq.peekFirst().a;
                int tx = dq.pollFirst().b;
                isExist[ty][tx] = false;
            }

            if (!q.isEmpty() && q.peek().a == time)
                dir = (dir + q.poll().b) % 4;

        }

    }
}
