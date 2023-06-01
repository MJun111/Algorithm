import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        
        int idx = 0;
        long cnt = 0;
        while (++idx <= n) {
            if (cnt + n < left) {
                cnt += n;
                continue;
            } else if (cnt > right) {
                break;
            }
            
            for (int i = 1; i <= n; i++) {
                if (cnt >= left && cnt <= right) {
                    if (i < idx) {
                        list.add(idx);
                    } else {
                        list.add(i);
                    }
                }
                cnt++;
            }   
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}