import java.io.*;
import java.util.*;

/*
x좌표 최대, y좌표 최소에서 부터 사이즈를 조절해가며 광물 최대가치 탐색
 */

class Mineral implements Comparable<Mineral>{
    int x, v;
    Mineral(int x, int v) {
        this.x = x;
        this.v = v;
    }

    @Override
    public int compareTo(Mineral other) {
        return other.x - this.x;
    }
}

public class Main {
        static final int MAX = 100001;
        static int n, c;
        static ArrayList<Mineral>[] minerals = new ArrayList[MAX];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int x, y, v;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            if (minerals[y] == null) minerals[y] = new ArrayList<>();
            minerals[y].add(new Mineral(x, v));
        }

        PriorityQueue<Mineral> pq = new PriorityQueue<>();
        long ans = 0, sum = 0;
        int idx = 0, cnt = 0;
        
        while(idx < MAX) {
            if (cnt >= n) break;
            if (minerals[idx] == null) { idx++; continue; }

            for (Mineral mineral : minerals[idx]) {
                pq.add(mineral);
                sum += mineral.v;
                cnt++;
            }

            while (!pq.isEmpty() && pq.size() > c) {
                int preX = pq.peek().x;

                // 해당 x구간 원소 모두 삭제 -> 구간 조건이 있으므로 필요함
                while(!pq.isEmpty() && pq.peek().x >= preX)
                    sum -= pq.poll().v;
            }

            ans = Math.max(ans, sum);
            idx++;
        }
        System.out.println(ans);
    }
}
