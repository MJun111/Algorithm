import java.io.*;
import java.util.*;

import static java.lang.System.out;

class Pair {
    int y, x;
    Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int r, c, n;
    static char[][] map;
    static Stack<Pair>[] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][];
        for (int i = 0; i < r; i++)
            map[i] = br.readLine().toCharArray();

        path = new Stack[c];
        for (int i = 0; i < c; i++)
            path[i] = new Stack<>();

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int order = Integer.parseInt(br.readLine()) - 1;

            // 저장된 경로가 있고, 돌멩이로 채워져 있지 않을 때 까지 올라감
            while(!path[order].isEmpty() && map[path[order].peek().y][path[order].peek().x] == 'O')
                path[order].pop();

            // 돌멩이로 채워지지 않은 저장된 경로가 없다면 초기 열부터 시뮬레이션
            if(path[order].isEmpty())
                simulate(0, order, order);
            // 경로가 있다면 해당 위치부터 시뮬레이션
            else
                simulate(path[order].peek().y, path[order].peek().x, order);
        }

        // output
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        out.print(sb);
    }

    static void simulate(int y, int x, int origin) {
        // 아래가 장애물이 아닐 동안
        while(y + 1 < r && map[y + 1][x] != 'X') {
            // 돌멩이를 만났다면
            if (map[y + 1][x] == 'O') {
                // 왼쪽 아래로
                if (x - 1 >= 0 && map[y][x - 1] == '.' && map[y + 1][x - 1] == '.') {
                    y++;
                    x--;
                }
                // 오른쪽 아래로
                else if (x + 1 < c && map[y][x + 1] == '.' && map[y + 1][x + 1] == '.') {
                    y++;
                    x++;
                }
                else break;
            }
            // 돌멩이나 장애물을 만날 때 까지 아래로
            else y++;

            // path에 경로 저장
            path[origin].push(new Pair(y, x));
        }

        map[y][x] = 'O';
    }
}
