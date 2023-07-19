import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Set<String> cache = new HashSet<>();
        Queue<String> recent = new ArrayDeque<>();
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        for (String str : cities) {
            str = str.toLowerCase();
            if (!cache.contains(str)) {
                if (cache.size() >= cacheSize) {
                    cache.remove(recent.poll());
                }
                cache.add(str);
                recent.add(str);
                
                answer += 5;
            } else {
                recent.remove(str);
                recent.add(str);
                answer += 1;
            }
            System.out.println();
        }
        
        return answer;
    }
}