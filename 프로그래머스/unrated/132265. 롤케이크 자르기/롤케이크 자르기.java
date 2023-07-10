import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < topping.length; i++) {
            map2.put(topping[i], map2.getOrDefault(topping[i], 0) + 1);
        }
        
        for (int i = 0; i < topping.length; i++) {
            map1.put(topping[i], map1.getOrDefault(topping[i], 0) + 1);
            map2.put(topping[i], map2.get(topping[i]) - 1);
            
            if (map2.get(topping[i]) == 0) {
                map2.remove(topping[i]);
            }
            
            if (map1.size() == map2.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}