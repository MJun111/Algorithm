import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n, x, ans = 0;
        int[] arr;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (arr[i] > x)
                break;

            int L = 0, R = n - 1;

            while(L <= R) {
                int M = (L + R) / 2;
                if (arr[i] + arr[M] < x) {
                    L = M + 1;
                }
                else if (arr[i] + arr[M] > x) {
                    R = M - 1;
                }
                else if (arr[i] + arr[M] == x){
                    ans++;
                    break;
                }
            }
        }
        sb.append(ans/2);
        System.out.println(sb);
    }
}
