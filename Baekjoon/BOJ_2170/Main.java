import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int start, end;

    @Override
    public int compareTo(Pair p) {
        return this.start - p.start;
    }
}

public class Main {
    static int n, ans;
    static Pair[] dot;
    public static void main(String[] args) throws IOException {
        input();
        findLine();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        dot = new Pair[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            dot[i] = new Pair();
            dot[i].start = Integer.parseInt(st.nextToken());
            dot[i].end = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dot);
    }

    static void findLine() {
        int l = dot[0].start;
        int r = dot[0].end;

        for (int i = 1; i < n; i++) {
            if (dot[i].start <= r) {
                if (dot[i].end > r)
                    r = dot[i].end;
            }
            else {
                ans += r - l;
                l = dot[i].start;
                r = dot[i].end;
            }
        }
        ans += r - l;
        System.out.println(ans);
    }
}
