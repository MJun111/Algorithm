import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int [3];
        for (int i = 0; i < 3; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int num = arr[0] * arr[1] * arr[2];
        arr = new int[10];

        while(num != 0) {
            arr[num % 10]++;
            num /= 10;
        }
        for (int a : arr)
            System.out.println(a);
    }
}
