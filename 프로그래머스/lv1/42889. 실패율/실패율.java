import java.util.*;

class Solution {
    class Stage implements Comparable<Stage> {
        int st;
        float p;
        
        public Stage(int st, float p) {
            this.st = st;
            this.p = p;
        }
        
        public int compareTo(Stage other) {
            if (Float.compare(this.p, other.p) == 0) {
                return this.st - other.st;
            }
            return Float.compare(other.p, this.p);
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        Map<Integer, Integer> arrive = new HashMap<>();
        
        for (int st : stages) {
            arrive.merge(st, 1, Integer::sum);
        }
        
        PriorityQueue<Stage> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            int clear = 0;
            float percent = 0;
            
            for (int j = N + 1; j >= i; j--) {
                if (arrive.get(j) == null) continue;
                
                clear += arrive.get(j);
            }
            
            if (clear != 0) {
                percent = (float)arrive.getOrDefault(i, 0) / clear;
            }
            
            pq.add(new Stage(i, percent));
        }
        
        int idx = 0;
        while (!pq.isEmpty()) {
            answer[idx++] = pq.poll().st;
        }
        
        return answer;
    }
}