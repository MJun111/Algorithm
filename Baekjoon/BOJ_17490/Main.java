import java.io.*;
import java.util.*;

/*
공사 구간이 2개 미만 -> 모두 연결되어있음
 */

public class Main {
    static int n, m;
    static long k;
    static boolean[] cons;
    static long[] s;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());

        // 공사 구간 2개 미만일 경우
        if (m < 2) {
            sb.append("YES");
            System.out.println(sb);
            System.exit(0);
        }

        cons = new boolean[n + 1];
        s = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            s[i] = Long.parseLong(st.nextToken());

        // 공사 구간인 부분 중 작은 부분을 cons배열에서 true로 체크
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // n 과 1 사이일 경우 n을 체크
            if ((a == 1 || a == n) && (b == 1 || b == n)) {
                if (a == n)
                    cons[a] = true;
                else
                    cons[b] = true;
            }
            else if (a < b)
                cons[a] = true;
            else
                cons[b] = true;
        }
    }

    static void solution() {
        ArrayList<PriorityQueue<Long>> section = new ArrayList<>();
        section.add(new PriorityQueue<>());

        // 구간 별 돌 갯수를 pq에 추가
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            section.get(idx).add(s[i]);
            if (cons[i] && i != n) {
                section.add(new PriorityQueue<>());
                idx++;
            }
        }

        // n번과 1번이 공사중이 아니라면 끝 구간과 첫 번째 구간을 합침
        if (!cons[n]) {
            for (int i = 0; i < section.get(idx).size(); i++)
                section.get(0).add(section.get(idx).poll());

            idx--;
        }

        // 각 구역 별 다리를 놓는 데 필요한 최소 돌 갯수만큼을 가져와 더한 후 k와 비교
        long sum = 0;
        for (int i = 0; i <= idx; i++)
            sum += section.get(i).poll();

        if (sum <= k)
            sb.append("YES");
        else
            sb.append("NO");

        System.out.println(sb);
    }

}
