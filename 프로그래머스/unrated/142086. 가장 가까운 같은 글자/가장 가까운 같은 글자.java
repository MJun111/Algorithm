import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] alpha = new int[26];
        
        Arrays.fill(alpha, -1);
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (alpha[c - 'a'] == -1)
                answer[i] = alpha[c - 'a'];
            else
                answer[i] = i - alpha[c - 'a'];
                
            alpha[c - 'a'] = i;
        }
        
        return answer;
    }
}