import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String[][] node;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            sb.append("#").append(tc).append(" ");
            n = Integer.parseInt(br.readLine());

            node = new String[n + 1][];

            for (int i = 1; i <= n; i++) {
                String tmp = br.readLine();
                node[i] = tmp.split(" ");
            }

            checkNode();
        }
        System.out.print(sb);
    }

    static void checkNode() {

        for (int i = 1; i <= n; i++) {
            if (node[i].length > 2)
                switch(node[i][1]) {
                    case "+": case "-": case "/": case "*":
                        break;
                    default:
                        sb.append("0").append("\n");
                        return;
                }
            else
                switch(node[i][1]) {
                    case "+": case "-": case "/": case "*":
                        sb.append("0").append("\n");
                        return;
                    default:
                        break;
                }
        }
        sb.append("1").append("\n");
    }
}
