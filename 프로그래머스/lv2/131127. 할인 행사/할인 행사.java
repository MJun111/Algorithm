import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        int idx = -1;
        while(++idx < discount.length - 9) {
            Map<String, Integer> map = new HashMap<>();
            
            for (int i = idx; i < idx + 10; i++) {
                map.compute(discount[i], (k, v) -> (v == null) ? 1 : v + 1);
            }
            
            boolean flag = true;
            for (int i = 0; i < want.length; i++) {
                if (!map.containsKey(want[i]) || map.get(want[i]) < number[i]) {
                    flag = false;
                    break;
                }
            }
            
            if (flag)
                answer++;
        }
        
        return answer;
    }
}