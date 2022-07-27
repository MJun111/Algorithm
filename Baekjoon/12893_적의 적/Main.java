import java.util.*;
import java.io.*;

public class Main {
    static int[] parent = new int[2001];
    static int[] enemyGroup = new int[2001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n, m;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        // 초기 부모는 자기 자신
        for (int i = 1; i <= n; i++)
            parent[i] = i;

        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            int ap = find(a);
            int bp = find(b);
            
            // 적대 관계의 부모가 같다면 모순 -> 0 출력 후 종료
            if (ap == bp) {
                sb.append(0);
                System.out.println(sb);
                System.exit(0);
            }
            
            // a와 적대 관계인 그룹의 부모를 enemyGroup[a]에 지정
            if (enemyGroup[a] != 0) {
                join(enemyGroup[a], b);
            } else {
                enemyGroup[a] = b;
            }

            if (enemyGroup[b] != 0) {
                join(enemyGroup[b], a);
            } else {
                enemyGroup[b] = a;
            }
        }
        sb.append(1);
        System.out.println(sb);
    }
    static int find(int u) {
        if (parent[u] == u)
            return u;
        return parent[u] = find(parent[u]);
    }
    static void join(int a, int b) {
        int ap = find(a);
        int bp = find(b);

        if (ap == bp)
            return;

        parent[ap] = bp;
    }
}
