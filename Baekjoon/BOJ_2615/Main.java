import java.util.*;
import java.io.*;

// 6목 X, 방향 고려 (8방 중 왼 -> 오 위주)
public class Main {
    static int map[][] = new int[22][22];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] dr = {-1, 0, 1, 1};
        int[] dc = {1, 1, 1, 0};

        for (int i = 1; i <= 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                if (map[i][j] == 0) continue;

                for (int d = 0; d < 4; d++) {
                    if(map[i][j] == map[i + dr[d] * -1][j + dc[d] * -1]) continue;
                    int cnt = 1;
                    while (map[i][j] == map[i + dr[d] * cnt][j + dc[d] * cnt]) cnt++;

                    if (cnt == 5) {
                        System.out.println(map[i][j]);
                        System.out.print(i + " " + j);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}
