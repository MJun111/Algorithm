import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < reserve.length; i++) {
            boolean flag = true;
            for (int j = 0; j < lost.length; j++) {
                if (lost[j] == reserve[i]) {
                    lost[j] = -1;
                    flag = false;
                    break;
                }
            }
            if (flag) {
                set.add(reserve[i]);
            }
        }
        
        int max = Math.max(simul(set, lost, false), simul(set, lost, true));
        int cnt = 0;
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == -1) continue;
            cnt++;
        }
        answer = n - cnt + max;
        return answer;
    }
    
    public int simul(Set<Integer> origin, int[] lost, boolean flag) {
        Set<Integer> set = new HashSet<>(origin);
        int cnt = 0;
        
        if (flag) {
            for (int i = 0; i < lost.length; i++) {
                if (set.contains(lost[i] - 1)) {
                    cnt++;
                    set.remove(lost[i] - 1);
                } else if (set.contains(lost[i] + 1)) {
                    cnt++;
                    set.remove(lost[i] + 1);
                }
            }
        } else {
            for (int i = 0; i < lost.length; i++) {
                if (set.contains(lost[i] + 1)) {
                    cnt++;
                    set.remove(lost[i] + 1);
                } else if (set.contains(lost[i] - 1)) {
                    cnt++;
                    set.remove(lost[i] - 1);
                } 
            }
        }
        
        if (cnt > lost.length) {
            cnt = lost.length;
        }
        
        return cnt;
    }
}