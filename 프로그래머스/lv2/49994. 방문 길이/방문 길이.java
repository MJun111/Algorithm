import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int x = 0;
        int y = 0;
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < dirs.length(); i++) {
            int reX = x;
            int reY = y;
            char s = dirs.charAt(i);
            
            if (s == 'U' && y < 5)
                y++;
            else if (s == 'D' && y > -5)
                y--;
            else if (s == 'R' && x < 5)
                x++;
            else if (s == 'L' && x > -5)
                x--;

            String xy = x + "";
            xy += y + "";
            String reXY = reX + "";
            reXY += reY + "";
            
            String st = xy + reXY;
            String nd = reXY + xy;
            
            if (set.contains(st) || set.contains(nd) || st.equals(nd)) continue;
            set.add(st);
            set.add(nd);
        }
        
        answer = set.size() / 2;
        return answer;
    }
}