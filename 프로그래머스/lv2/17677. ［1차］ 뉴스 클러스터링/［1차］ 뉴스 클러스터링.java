import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        int cnt1 = addMap(map1, str1);
        int cnt2 = addMap(map2, str2);

        int dupl = 0;
        for (Map.Entry<String, Integer> entry1 : map1.entrySet()) {
            String key = entry1.getKey();
            if (map2.containsKey(key)) {
                dupl += Math.min(entry1.getValue(), map2.get(key));
            }
        }
        
        float combi = cnt1 + cnt2 - dupl;
        if (combi == 0) return 65536;
        
        return (int)(dupl / combi * 65536);
    }
    
    public int addMap(Map<String, Integer> map, String str) {
        int cnt = 0;
        char c1, c2;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str.length() - 1; i++) {
            c1 = Character.toLowerCase(str.charAt(i));
            c2 = Character.toLowerCase(str.charAt(i + 1));
            
            if (!Character.isLetter(c1) || !Character.isLetter(c2)) continue;
            
            sb.append(c1).append(c2);
            map.merge(sb.toString(), 1, Integer::sum);
            sb.setLength(0);
            cnt++;
        }
        return cnt;
    }
}