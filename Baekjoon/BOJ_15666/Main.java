import java.io.*;
import java.util.*;

// visited배열을 두어 이전과 같은 원소 선택X

public class Main {
    static int n, m;
    static int[] in;
    static int[] out;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        in = new int[n];
        out = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(in);
        combi(0, 0);
        System.out.print(sb);
    }

    static void combi(int start, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++)
                sb.append(out[i] + " ");
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if (i != 0 && !visited[i - 1] && in[i] == in[i - 1]) continue;
            visited[i] = true;
            out[depth] = in[i];
            combi(i, depth + 1);
            visited[i] = false;
        }
    }
}

/*  
import java.io.*;
import java.util.*;

// 기존 조합 -> Set -> ArrayList를 이용하여 중복 제거

class Seq implements Comparable<Seq> {
    ArrayList<Integer> list = new ArrayList<>();
    Seq(int[] nums) {
        for (int num : nums)
            list.add(num);
    }

    @Override
    public int compareTo(Seq o) {
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i) - o.list.get(i) != 0)
                return this.list.get(i) - o.list.get(i);
        }
        return 0;
    }
}

public class Main {
    static int n, m;
    static int[] in;
    static int[] out;
    static Set<String> set = new HashSet<>();
    static ArrayList<Seq> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        in = new int[n];
        out = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(in);
        combi(0, 0);
        for (String str : set) {
            int[] nums = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
            ans.add(new Seq(nums));
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(ans);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).list.size(); j++) {
                sb.append(ans.get(i).list.get(j)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void combi(int start, int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++)
                sb.append(out[i] + " ");
            set.add(sb.toString());
            return;
        }

        for (int i = start; i < n; i++) {
            out[depth] = in[i];
            combi(i, depth + 1);
        }
    }
}
 */
