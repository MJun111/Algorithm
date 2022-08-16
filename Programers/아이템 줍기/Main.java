import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 2 * 50;
    static int[][] map = new int[MAX + 2][MAX + 2];
    static int[] dy = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dx = {0, -1, 0, 1, -1, 1, -1, 1};
    public static void main(String[] args) throws IOException {
        int[][] rectangle = {{1,1,8,4}, {2,2,4,9}, {3,6,9,8}, {6,3,7,7}};
        int characterX = 9, characterY = 7, itemX = 6, itemY = 1;
        solution(rectangle, characterX, characterY, itemX, itemY);
    }

    static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        setMap(rectangle, itemX, itemY);
        answer = bfs(characterX, characterY, new boolean[MAX + 2][MAX + 2]);
        System.out.println(answer);
        return answer;
    }

    static void setMap(int[][] rectangle, int itemX, int itemY) {

        for (int rec = 0; rec < rectangle.length; rec++) {
            int x1 = rectangle[rec][0] * 2;
            int y1 = rectangle[rec][1] * 2;
            int x2 = rectangle[rec][2] * 2;
            int y2 = rectangle[rec][3] * 2;

            for (int i = y1; i <= y2; i++)
                for (int j = x1; j <= x2; j++)
                    map[i][j]++;
        }
        map[2 * itemY][2 * itemX] = -1;
    }

    static int bfs(int characterX, int characterY, boolean[][] visited) {
        int ans = 987654321;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(2 * characterY);
        q.add(2 * characterX);
        q.add(0);
        visited[2 * characterY][2 * characterX] = true;

        while(!q.isEmpty()) {
            int y = q.poll();
            int x = q.poll();
            int cnt = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny <= 0 || nx <= 0 || ny > MAX || nx > MAX) continue;
                if (map[ny][nx] == 0) continue;
                if (map[ny][nx] == -1) {
                    ans = Math.min(ans, (cnt + 1) / 2);
                }

                if (visited[ny][nx]) continue;

                for (int j = 0; j < 8; j++) {
                    int cy = ny + dy[j];
                    int cx = nx + dx[j];
                    if (map[cy][cx] == 0) {
                        visited[ny][nx] = true;
                        q.add(ny);
                        q.add(nx);
                        q.add(cnt + 1);
                        break;
                    }
                }
            }
        }
        return ans;
    }

}
