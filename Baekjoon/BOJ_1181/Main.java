import java.io.*;
import java.util.*;

public class Main {
    static class myStr implements Comparable<myStr> {
        String s;

        public myStr(String s) {
            this.s = s;
        }

        @Override
        public int compareTo(myStr o) {
            if (this.s.length() == o.s.length())
                return this.s.compareTo(o.s);
            return Integer.compare(this.s.length(), o.s.length());
        }
    }

    static ArrayList<myStr> str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        str = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            str.add(new myStr(br.readLine()));
        }

        Collections.sort(str);
        String cur = str.get(0).s;
        sb.append(cur + "\n");
        for (int i = 1; i < n; i++) {
            if (cur.equals(str.get(i).s)) continue;
            sb.append(str.get(i).s + "\n");
            cur = str.get(i).s;
        }
        System.out.print(sb);
    }
}
