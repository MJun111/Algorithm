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
        int[] arriveSum = new int[N + 2];
        Map<Integer, Integer> arrive = new HashMap<>();
            
        for (int st : stages) {
            arrive.merge(st, 1, Integer::sum);
        }
        
        arriveSum[N + 1] = arrive.getOrDefault(N + 1, 0);
        for (int i = N; i >= 1; i--) {
            arriveSum[i] = arriveSum[i + 1] + arrive.getOrDefault(i, 0);
        }
        
        PriorityQueue<Stage> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            float percent = 0;
            
            if (arriveSum[i] != 0) {
                percent = (float)arrive.getOrDefault(i, 0) / arriveSum[i];
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