import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int cnt = 1;
        int pointer = 0;
        while(cnt <= n) {
            st.push(cnt++);
            sb.append("+\n");

            while (!st.empty() && st.peek() == arr[pointer]) {
                sb.append("-\n");
                pointer++;
                st.pop();
            }
        }
        if (st.empty())
            System.out.println(sb);
        else
            System.out.println("NO");
    }
}
