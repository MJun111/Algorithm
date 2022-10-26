import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = "-1 -2 -3 -4";
        System.out.println(solution(str));

    }

    static public String solution(String s) {
        String answer = "";
        String[] nums = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, Integer.parseInt(nums[i]));
            min = Math.min(min, Integer.parseInt(nums[i]));
        }

        answer = min + " " + max;
        return answer;
    }
}
