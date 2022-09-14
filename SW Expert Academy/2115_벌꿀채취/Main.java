import java.io.*;
import java.util.*;

/*
메모리 : 20,168 kb
실행시간 : 125 ms
코드길이 : 3,260
꿀 채취 가능한 모든 경우의 수를 구함, 이 때 c를 넘는 경우는 부분집합으로 최대로 수확할 수 있게 선택
이후 모든 경우의 수를 비교하며 중복되지 않는 경우만 체크하여 최대값 비교
 */


class Honey {
    // 꿀을 채취하기 시작한 y, x 좌표 및 amount 양
    int y, x, amount;
    Honey(int y, int x, int amount) {
        this.y = y;
        this.x = x;
        this.amount = amount;
    }
}

public class Main {
    static int n, m, c;
    static int ans, idx, tmp;   // ans : 최종 답안, idx : 꿀 채취 가능한 경우의 수, tmp : 임시로 지정한 꿀 양
    static int[][] map;
    static Honey[] honey;       // 꿀을 채취할 수 있는 경우의 수가 모두 담긴 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            sb.append("#" + tc + " ");
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            honey = new Honey[n * n];
            ans = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            getHoney();
            findMax();
            sb.append(ans + "\n");
        }
        System.out.print(sb);
    }

    static void getHoney() {
        idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - m + 1; j++) {
                tmp = 0;
                int sum = 0;
                int[] nums = new int[m];
                // m개의 칸에서 꿀 채취
                for (int k = j; k < j + m; k++) {
                    sum += map[i][k];
                    nums[k - j] = map[i][k];
                }
                // 만약 꿀의 양이 c 범위를 넘어간다면 부분집합으로 선택
                if (sum > c) {
                    pickNum(nums, new boolean[m], 0, 0);
                }
                else {
                    for (int k = 0; k < m; k++)
                        tmp += nums[k] * nums[k];
                }
                // 꿀 양 및 채취 좌표 담아둠
                honey[idx++] = new Honey(i, j, tmp);
            }
        }
    }

    static void findMax() {
        // 꿀 양 비교하며 최대값을 찾음
        for (int i = 0; i < idx - 1; i++) {
            for (int j = i + 1; j < idx; j++) {
                if (honey[i].amount + honey[j].amount > ans) {
                    // 최대값 갱신 여지가 있는 배열들이면 중복되어있지 않은지 검사 후 갱신
                    if (isValid(honey[i], honey[j])) {
                        ans = honey[i].amount + honey[j].amount;
                    }
                }
            }
        }
    }

    static void pickNum(int[] nums, boolean[] isSelected, int depth, int sum) {
        if (depth == m) {
            // 부분집합 최종 선택 후 합을 넘었으면 돌아감
            if (sum > c)
                return;

            int res = 0;
            for (int i = 0; i < m; i++) {
                if (isSelected[i])
                    res += nums[i] * nums[i];
            }
            tmp = Math.max(tmp, res);

            return;
        }
        // 선택 도중 합을 넘어가면 돌아감
        if (sum > c)
            return;

        isSelected[depth] = true;
        pickNum(nums, isSelected, depth + 1, sum + nums[depth]);

        isSelected[depth] = false;
        pickNum(nums, isSelected, depth + 1, sum);
    }

    static boolean isValid(Honey a, Honey b) {
        // 같은 행에 열 차이가 m 이하라면 중복된 부분
        if (a.y == b.y) {
            if (b.x - a.x < m)
                return false;
        }
        return true;
    }

}
