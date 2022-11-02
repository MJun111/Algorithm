import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String word = "AAAE";

        System.out.println(solution(word));

    }

    /*
    1 * 5 + 1 = 6
    6 * 5 + 1 = 31
    31 * 5 + 1 = 156
    156 * 5 + 1 = 781
     */

    public static int solution(String word) {
        int answer = word.length();
        int[] nums = {781, 156, 31, 6, 1};
        Map<Character, Integer> m = new HashMap<>();
        m.put('A', 0);
        m.put('E', 1);
        m.put('I', 2);
        m.put('O', 3);
        m.put('U', 4);

        for (int i = 0; i < word.length(); i++) {
            answer += m.get(word.charAt(i)) * nums[i];
        }

        return answer;
    }
}
