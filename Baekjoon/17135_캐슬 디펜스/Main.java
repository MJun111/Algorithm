package algorithm;

import java.util.*;
import java.io.*;

// 궁수 3명 고정, 궁수 위치는 n + 1번째 행 어디든, 1칸에 1명의 궁수
class tri {
    int a, b, c;
    tri(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class Main {
    static int n, m, d;
    static int[][] map;
    static ArrayList<tri> arr;
    static int[] dc = {-1, 0, 1};       // 왼 -> 위 -> 오
    static int[] dr = {0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        input();
    	setArcher();
        goGame();
    }
    
    static void input() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        // input map
        map = new int [n + 1][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    
    static void setArcher() {
        arr = new ArrayList<>();
        boolean[] visited = new boolean[m];
        combination(visited, 0, 3);
        
    }
    
    static void goGame() {
        int ans = 0;
        int testCase = 0;
        while (testCase < arr.size()) {
            int[][] copyMap = new int[n + 1][m];

            for (int i = 0; i <= n; i++)
                copyMap[i] = map[i].clone();

            // archer.x 좌표
            int[] dc = new int[3];
            dc[0] = arr.get(testCase).a;
            dc[1] = arr.get(testCase).b;
            dc[2] = arr.get(testCase).c;

            int turn = 0;
            int killSoldier = 0;
            while (turn < n) {
                boolean[][] isDead = new boolean[n][m];     // 같은 적을 쐈는지 확인할 배열
                for (int archer = 0; archer < 3; archer++) {
                    if (copyMap[n - 1][dc[archer]] == 1) {  // 거리가 1이면 바로 픽
                        isDead[n - 1][dc[archer]] = true;
                    } else {                                // 아니라면 탐색
                        BFS(n - 1, dc[archer], isDead, copyMap);
                    }
                }
                killSoldier += kill(isDead, copyMap);       // 죽인 적군 수 카운트

                for (int i = n - 1; i >= 0; i--) {          // 한 칸씩 아래로 내림
                    for (int j = 0; j < m; j++) {
                        if (copyMap[i][j] == 1) {
                            copyMap[i][j] = 0;
                            if (i + 1 < n)
                                copyMap[i + 1][j] = 1;
                        }
                    }
                }
                turn++;
            }

            ans = Math.max(ans, killSoldier);
            testCase++;
        }

        System.out.println(ans);
    }
    
    static void combination(boolean[] visited, int start, int r) {
        if (r == 0) {
            int size = 0;
            int a[] = new int[3];

            for (int i = 0; i < m; i++)
                if (visited[i] == true)
                    a[size++] = i;

            arr.add(new tri(a[0], a[1], a[2]));
            return;
        } else {
            for (int i = start; i < m; i++) {
                visited[i] = true;
                combination(visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }
    
    static void BFS(int r, int c, boolean[][] isDead, int[][] copyMap) {
        Queue<Integer> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        q.add(r);
        q.add(c);
        visited[r][c] = true;

        for (int cnt = 1; cnt < d; cnt++) {         // 사정거리만큼 탐색
            int size = q.size() / 2;

            for (int a = 0; a < size; a++) {
                int qr = q.poll();
                int qc = q.poll();

                for (int i = 0; i < 3; i++) {
                    int nr = qr + dr[i];
                    int nc = qc + dc[i];

                    if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                    if (visited[nr][nc]) continue;

                    if (copyMap[nr][nc] == 1) {     // 탐색되면 배열에 픽
                        isDead[nr][nc] = true;
                        return;
                    }

                    q.add(nr);                      // 안되면 계속 탐색
                    q.add(nc);
                    visited[nr][nc] = true;
                }
            }
        }
    }
    
    static int kill (boolean[][] isDead, int[][] copyMap) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isDead[i][j]) {
                    cnt++;
                    copyMap[i][j] = 0;
                }
            }
        }
        return cnt;
    }
}
