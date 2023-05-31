import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 1; i <= elements.length; i++) {
            // 연속 부분 수열의 길이가 i인 합의 종류
            int idx = 0;
            
            while (idx < elements.length) {
                int sum = 0;
                
                for (int j = idx; j < idx + i; j++) {
                    sum += elements[j % elements.length];
                }
                
                set.add(sum);
                idx++;
            }
        }
        
        return set.size();
    }
}