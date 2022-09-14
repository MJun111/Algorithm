import java.io.*;
import java.util.*;

/*
메모리 : 18,612 kb
실행 시간 : 116 ms
코드 길이 : 1,574
setIn() : 입력 숫자를 n/4 단위로 나누어 TreeSet에 넣어 정렬
rotate() : 입력 숫자 한칸씩 밈
TreeSet 완성되면 k번째 수 뽑아냄
 */

public class Main {
    static int n, k, d;
    static String input;
    static TreeSet<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            sb.append("#" + tc + " ");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            d = n / 4;
            set = new TreeSet<>(Collections.reverseOrder());

            input = br.readLine();

            for (int i = 0; i < d; i++) {
                rotate();
                setIn();
            }

            int cnt = 0;
            for (Integer num : set) {
                if (++cnt == k) {
                    sb.append(num + "\n");
                    break;
                }
            }
        }
        System.out.print(sb);
    }

    static void rotate() {
        String tmp = input.charAt(n - 1) + "";
        for (int i = 0; i < n - 1; i++)
            tmp += input.charAt(i);
        input = tmp;
    }

    static void setIn() {
        String tmp = "0x";
        for (int i = 0; i < n; i++) {
            tmp += input.charAt(i);
            if ((i + 1) % d == 0) {
                set.add(Integer.decode(tmp));
                tmp = "0x";
            }
        }
    }
}
