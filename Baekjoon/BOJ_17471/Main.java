import java.io.*;
import java.util.*;

public class Main {
    static int n, sum;  // n : 지역구 수, sum : 인구수 총 합
    static int ans = Integer.MAX_VALUE;
    static int[] Districts;
    static ArrayList<Integer>[] node;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        // 지역구 별 인구수
        Districts = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            Districts[i] = Integer.parseInt(st.nextToken());
            sum += Districts[i];
        }

        // 지역 별 연결관계
        node = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            node[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            for (int j = 0; j < m; j++) {
                int next = Integer.parseInt(st.nextToken());
                node[i].add(next);
            }
        }

        // 지역구 두개로 나뉘는 모든 조합 실행
        for (int i = 1; i <= (n + 1) / 2; i++) {
            gerrymandering(i, 1, new boolean[n + 1]);
        }

        // 유효한 분할이 없으면 -1
        if (ans == Integer.MAX_VALUE)
            ans = -1;

        System.out.println(ans);
    }

    public static void gerrymandering(int cnt, int start, boolean[] visited) {
        // 조합이 완료될 경우 A, B로 나누어 유효성 검사 후 인구수 차이 비교
        if (cnt == 0) {
            Set<Integer> A = new HashSet<>();
            for (int i = 1; i <= n; i++)
                if (visited[i])
                    A.add(i);

            Set<Integer> B = new HashSet<>();
            for (int i = 1; i <= n; i++)
                B.add(i);
            B.removeAll(A);

            // 지역구 분할이 유효하다면 인구수 비교
            if (isCorrect(A, B)) {
                int aSum = 0, bSum = 0;
                for (Integer num : A) {
                    aSum += Districts[num];
                }
                bSum = sum - aSum;
                ans = Math.min(ans, Math.abs(aSum - bSum));
            }
        }

        // 조합 선정
        for (int i = start; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                gerrymandering(cnt - 1, i + 1, visited);
                visited[i] = false;
            }
        }
    }

    public static boolean isCorrect(Set<Integer> A, Set<Integer> B) {
        boolean[] check = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        // A 탐색
        Iterator<Integer> iter = A.iterator();
        int start = iter.next();
        q.add(start);
        check[start] = true;

        while(!q.isEmpty()) {
            int d = q.poll();
            for (int i = 0; i < node[d].size(); i++) {
                int next = node[d].get(i);
                // 방문하지 않았고, A 구역에 포함되어있을 경우 큐에 삽입
                if (!check[next] && A.contains(next)) {
                    check[next] = true;
                    q.add(next);
                }
            }
        }

        // B 탐색
        q.clear();
        iter = B.iterator();
        start = iter.next();
        q.add(start);
        check[start] = true;

        while(!q.isEmpty()) {
            int d = q.poll();
            for (int i = 0; i < node[d].size(); i++) {
                int next = node[d].get(i);
                if (!check[next] && B.contains(next)) {
                    check[next] = true;
                    q.add(next);
                }
            }
        }

        // 한 곳이라도 방문하지 않았다면 유효한 분할이 아니므로 false
        for (int i = 1; i <= n; i++)
            if (check[i] == false)
                return false;

        return true;
    }
}
