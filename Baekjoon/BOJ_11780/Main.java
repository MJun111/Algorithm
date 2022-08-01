import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] info;
    static int[][] path;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        input();
        floyd(n);
        print_ans();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        info = new int[n + 1][n + 1];
        path = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i ++)
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    info[i][j] = 0;
                else
                    info[i][j] = Integer.MAX_VALUE / 2;
            }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            info[a][b] = Math.min(info[a][b], c);
        }
    }

    static void floyd(int n) {
        for (int mid = 1; mid <= n; mid++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    if (start == end) continue;
                    if (info[start][end] > info[start][mid] + info[mid][end]) {
                        info[start][end] = info[start][mid] + info[mid][end];
                        path[start][end] = mid;
                    }
                }
            }
        }
    }

    static void findPath(int start, int end) {
        if (path[start][end] == 0) {
            list.add(start);
            list.add(end);
            return;
        }
        findPath(start, path[start][end]);
        list.remove(list.size() - 1);
        findPath(path[start][end], end);
    }

    static void print_ans() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (info[i][j] == Integer.MAX_VALUE / 2)
                    sb.append(0 + " ");
                else
                    sb.append(info[i][j] + " ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    sb.append("0\n");
                } else if (info[i][j] == Integer.MAX_VALUE / 2) {
                    sb.append("0\n");
                } else {
                    list.clear();
                    findPath(i, j);
                    sb.append(list.size() + " ");
                    for (int k = 0; k < list.size(); k++)
                        sb.append(list.get(k) + " ");
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }

}
