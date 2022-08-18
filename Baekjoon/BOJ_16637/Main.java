import java.io.*;
import java.util.*;

public class Main {
    static int n, ans = Integer.MIN_VALUE;
    static String input;
    static int[] nums;
    static char[] operators;
    static boolean[] useBrackets;
    public static void main(String[] args) throws IOException {
        input();
        solve(1);
        System.out.println(ans);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[(n + 1) / 2 + 1];
        operators = new char[(n - 1) / 2 + 1];
        useBrackets = new boolean[(n - 1) / 2 + 1];

        input = br.readLine();

        int j = 1, k = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                nums[j++] = input.charAt(i) - '0';
            else
                operators[k++] = input.charAt(i);
        }
    }

    static void solve(int cnt) {
        if (cnt == useBrackets.length) {
            calc();
            return;
        }

        if (!useBrackets[cnt - 1]) {
            useBrackets[cnt] = true;
            solve(cnt + 1);
        }
        useBrackets[cnt] = false;
        solve(cnt + 1);

    }

    static void calc() {
        int[] tmpNums = nums.clone();
        char[] tmpOperators = operators.clone();

        for (int i = 1; i < useBrackets.length; i++) {
            if (useBrackets[i]) {
                switch(operators[i]) {
                    case '+': tmpNums[i] = nums[i] + nums[i + 1]; break;
                    case '-': tmpNums[i] = nums[i] - nums[i + 1]; break;
                    case '*': tmpNums[i] = nums[i] * nums[i + 1]; break;
                }
                tmpOperators[i] = '.';
            }
        }

        int calcNum = tmpNums[1];
        for (int i = 1; i < useBrackets.length; i++) {
            if (tmpOperators[i] == '.') continue;
            switch(tmpOperators[i]) {
                case '+': calcNum += tmpNums[i + 1]; break;
                case '-': calcNum -= tmpNums[i + 1]; break;
                case '*': calcNum *= tmpNums[i + 1]; break;
            }
        }

        ans = Math.max(calcNum, ans);
    }
}
