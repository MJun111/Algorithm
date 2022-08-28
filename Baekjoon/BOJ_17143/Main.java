import java.io.*;
import java.util.*;

/*
1. 낚시왕이 오른쪽으로 한 칸 이동한다.
2. 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
3. 상어가 이동한다.

* d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽을 의미한다
 */

class Shark {
    int r, c, s, d, z;

    Shark(int r, int c, int s, int d, int z) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
    }

}

public class Main {
    static int R, C, M, ans;
    static Shark[] sharks;
    static int[][] map;
    static int[] col;
    static boolean[] isCatch;

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 1; i < C; i++) {
            fishing(i);
            sharkMove(i + 1);
        }
        fishing(C);
        System.out.println(ans);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        col = new int[C + 1];
        isCatch = new boolean[M + 1];
        sharks = new Shark[M + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            sharks[i] = new Shark(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );

            if (sharks[i].c == 1) {
                if (col[1] == 0)
                    col[1] = i;
                else {
                    if (sharks[i].r < sharks[col[1]].r)
                        col[1] = i;
                }
            }
        }
    }

    static void fishing(int sec) {
        if (col[sec] != 0) {
            ans += sharks[col[sec]].z;
            sharks[col[sec]].r = -1;
            sharks[col[sec]].c = -1;
            isCatch[col[sec]] = true;
        }
    }

    static void sharkMove(int sec) {
        // 상어가 같은 위치에 있는지 체크하기 위한 맵
        map = new int[R + 1][C + 1];
        for (int i = 1; i <= M; i++) {
            // 잡힌 상어라면 이동 X
            if (isCatch[i]) continue;

            // 이동
            int move = 0;
            switch (sharks[i].d) {
                case 1:
                case 2:
                    // 제자리로 돌아오는 오는 횟수 제외하고 생각
                    move = sharks[i].s % (2 * (R - 1));
                    while (move-- > 0) {
                        moveR(i);
                    }
                    break;
                case 3:
                case 4:
                    move = sharks[i].s % (2 * (C - 1));
                    while (move-- > 0) {
                        moveC(i);
                    }
                    break;
            }

            // 겹치는 상어 있는지 확인
            if (map[sharks[i].r][sharks[i].c] == 0)
                map[sharks[i].r][sharks[i].c] = i;
            else {
                int origin = map[sharks[i].r][sharks[i].c];
                if (sharks[i].z < sharks[origin].z) {
                    isCatch[i] = true;
                    sharks[i].r = -1;
                    sharks[i].c = -1;
                }
                else {
                    map[sharks[i].r][sharks[i].c] = i;
                    isCatch[origin] = true;
                    sharks[origin].r = -1;
                    sharks[origin].c = -1;
                }
            }
        }
        findCol(sec);
    }

    static void moveR(int i) {
        if(sharks[i].d == 2) {
            if (sharks[i].r < R)
                sharks[i].r++;
            else {
                sharks[i].d = 1;
                sharks[i].r--;
            }
        }
        else {
            if (sharks[i].r > 1)
                sharks[i].r--;
            else {
                sharks[i].d = 2;
                sharks[i].r++;
            }
        }
        // 끝이면 방향 미리 수정
        if (sharks[i].r == 1)
            sharks[i].d = 2;
        if (sharks[i].r == R)
            sharks[i].d = 1;
    }

    static void moveC(int i) {
        if(sharks[i].d == 3) {
            if (sharks[i].c < C)
                sharks[i].c++;
            else {
                sharks[i].d = 4;
                sharks[i].c--;
            }
        }
        else {
            if (sharks[i].c > 1)
                sharks[i].c--;
            else {
                sharks[i].d = 3;
                sharks[i].c++;
            }
        }
        // 끝이면 방향 미리 수정
        if (sharks[i].c == 1)
            sharks[i].d = 3;
        if (sharks[i].c == C)
            sharks[i].d = 4;
    }

    static void findCol(int sec) {
        for (int i = 1; i <= M; i++) {
            if (isCatch[i]) continue;

            if (sharks[i].c == sec) {
                if (col[sec] == 0)
                    col[sec] = i;
                else {
                    if (sharks[i].r < sharks[col[sec]].r)
                        col[sec] = i;
                }
            }
        }
    }

}
