import java.util.*;

class Solution {
    class Truck {
        int t, w;
        
        Truck(int t, int w) {
            this.t = t;
            this.w = w;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        ArrayList<Truck> arr = new ArrayList<>();
        
        int curWeight = 0;
        int idx = 0;
        while(true) {
            answer++;
            if (idx < truck_weights.length 
                    && weight >= curWeight + truck_weights[idx] 
                    && bridge_length >= arr.size() + 1
            ) {
                curWeight += truck_weights[idx];
                arr.add(new Truck(0, truck_weights[idx++]));
            }
            
            if (arr.isEmpty()) {
                break;
            }
            
            for (int i = arr.size() - 1; i >= 0; i--) {
                Truck tr = arr.get(i);
                tr.t += 1;
                if (tr.t >= bridge_length) {
                    arr.remove(i);
                    curWeight -= tr.w;
                }
            }
        }
        
        return answer;
    }
}