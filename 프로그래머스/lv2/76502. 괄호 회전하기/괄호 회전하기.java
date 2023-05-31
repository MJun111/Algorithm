import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        boolean flag = true;
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('(', 1);
        map.put('{', 2);
        map.put('[', 3);
        map.put(')', 4);
        map.put('}', 5);
        map.put(']', 6);
        
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        
        for (int i = 0; i < s.length(); i++) {
            flag = true;
            String str = sb.toString();
            Stack<Integer> st = new Stack<>();
            
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '[' 
                    || str.charAt(j) == '{' 
                    || str.charAt(j) == '('
                ) {
                    st.push(map.get(str.charAt(j)));    
                } else {
                    if (st.isEmpty()
                        || st.pop() + 3 != map.get(str.charAt(j))
                    ) {
                        flag = false;
                        break;
                    }
                }   
            }
            if (!st.isEmpty()) flag = false;
            if (flag) answer++;
            
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
        }
        
        return answer;
    }
}