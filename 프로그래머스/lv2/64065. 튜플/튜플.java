import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        StringBuilder sb = new StringBuilder();
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '{') {
                tmp = new ArrayList<>();
            } else if (s.charAt(i - 1) == '}' && s.charAt(i) == ',') {
                list.add(tmp);
            } else if (s.charAt(i) == ',' || s.charAt(i) == '}') {
                tmp.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            } else {
                sb.append(s.charAt(i));
            }
        }
        list.add(tmp);
        
        Collections.sort(list, (o1, o2) -> o1.size() - o2.size());
        ArrayList<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for (ArrayList<Integer> l : list) {
            for (int i = 0; i < l.size(); i++) {
                int num = l.get(i);
                if (set.contains(num)) continue;
                
                set.add(num);
                ans.add(num);
            }
        }
        
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}