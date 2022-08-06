import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        arr = new char[n + 1][2];
        String str;
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            arr[str.charAt(0) - 'A'][0] = str.charAt(2);
            arr[str.charAt(0) - 'A'][1] = str.charAt(4);
        }
        preorder('A');
        sb.append("\n");

        inorder('A');
        sb.append("\n");

        postorder('A');
        sb.append("\n");

        System.out.print(sb);
    }

    static void preorder(char x) {
        if (x == '.')
            return;

        sb.append(x);
        preorder(arr[x - 'A'][0]);
        preorder(arr[x - 'A'][1]);
    }

    static void inorder(char x) {
        if (x == '.')
            return;

        inorder(arr[x - 'A'][0]);
        sb.append(x);
        inorder(arr[x - 'A'][1]);
    }

    static void postorder(char x) {
        if (x == '.')
            return;

        postorder(arr[x - 'A'][0]);
        postorder(arr[x - 'A'][1]);
        sb.append(x);
    }
}
