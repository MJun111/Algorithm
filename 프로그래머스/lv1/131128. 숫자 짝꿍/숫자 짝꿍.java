import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[10];
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        for (int i = 0; i < X.length(); i++) {
            int num = X.charAt(i) - '0';
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        
        for (int i = 0; i < Y.length(); i++) {
            int num = Y.charAt(i) - '0';
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        
        for (int i = 0; i < 10; i++) {
            int num = Math.min(map1.getOrDefault(i, 0), map2.getOrDefault(i, 0));
            nums[i] = num;
        }
        
        for (int i = 9; i >= 0; i--) {
            while (nums[i] > 0) {
                sb.append(i);
                nums[i]--;
            }
        }
        
        if (sb.length() == 0) {
            answer = "-1";   
        } else if (sb.length() > 1 && sb.toString().charAt(0) == '0') {
            answer = "0";
        } else {
            answer = sb.toString();
        }
        return answer;
    }
}