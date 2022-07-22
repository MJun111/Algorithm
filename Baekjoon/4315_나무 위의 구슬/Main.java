import java.util.*;
import java.io.*;

public class Main {

        public static int n, ans;       
        public static int[] node;                   // 노드가 갖는 초기 구슬 개수
        public static int[] degree;                 // 차수
        public static ArrayList<Integer>[] list;    // 단방향 그래프
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        while(true) {
            n = Integer.parseInt(br.readLine());
            ans = 0;
            if (n == 0) break;

            node = new int[n + 1];
            degree = new int[n + 1];
            list = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++)
                list[i] = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int v = Integer.parseInt(st.nextToken());
                int ball = Integer.parseInt(st.nextToken());
                node[v] = ball;
                
                int d = Integer.parseInt(st.nextToken());
                for (int j = 0; j < d; j++) {
                    int child = Integer.parseInt(st.nextToken());
                    list[v].add(child);
                    degree[child]++;
                }
            }

            int root = 0;
            for (int i = 0; i < n; i++)
                if (degree[i] == 0)
                    root = i;

            dfs(root);
            sb.append(ans + "\n");
        }
        System.out.println(sb.toString());
    }

    public static int dfs(int idx) {
        int cnt = node[idx] - 1;        // 구슬 개수 - 1

        for (int child : list[idx])     // 트리를 순회하며 이동횟수 연산
            cnt += dfs(child);
        
        ans += Math.abs(cnt);           
        return cnt;
    }
}
