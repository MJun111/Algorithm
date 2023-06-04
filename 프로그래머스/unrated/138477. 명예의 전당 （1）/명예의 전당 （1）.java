import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        int idx = 0;
        List<Integer> list = new ArrayList<>();
        while (idx < score.length) {
            list.add(score[idx]);
            Collections.sort(list, Collections.reverseOrder());
            
            answer[idx] = idx < k ? list.get(idx) : list.get(k - 1);
            
            idx++;
        }
        
        return answer;
    }
}