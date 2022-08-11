import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, t;
    static int[][] checkLoca;
    static Queue<Integer> q = new ArrayDeque<>();
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        input();
        bfs();
        check();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        checkLoca = new int[K][2];      // y, x 순서
        visited = new boolean[2][N][N];

        // 곰팡이 좌표 큐에 삽입
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            q.add(b - 1);
            q.add(a - 1);
        }

        // 검사하는 좌표 배열에 담아 관리
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            checkLoca[i][1] = Integer.parseInt(st.nextToken()) - 1;
            checkLoca[i][0] = Integer.parseInt(st.nextToken()) - 1;
        }
    }

    static void bfs() {
        // 홀수, 짝수 곰팡이 위치 구분하여 방문
        int turn = 0;
        while(!q.isEmpty() && turn++ < t) {

            int size = q.size() / 2;
            // 한 번 방문에 이전 큐에 담겨있던 만큼만 실행
            for (int k = 0; k < size; k++) {
                int y = q.poll();
                int x = q.poll();

                for (int i = 0; i < 8; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                    if (visited[turn % 2][ny][nx]) continue;

                    visited[turn % 2][ny][nx] = true;
                    q.add(ny);
                    q.add(nx);
                }
            }
        }
    }

    static void check() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            int y = checkLoca[i][0];
            int x = checkLoca[i][1];
            // 방문하는 날에 곰팡이가 피어있는지 확인
            if (visited[t % 2][y][x]) {
                sb.append("YES");
                System.out.println(sb);
                return;
            }
        }
        sb.append("NO");
        System.out.println(sb);
    }
}
