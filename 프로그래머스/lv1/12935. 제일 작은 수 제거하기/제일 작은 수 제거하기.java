import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        arr = Arrays.stream(arr)
                    .filter(num -> num != min)
                    .toArray();
        
        if (arr.length == 0) {
            arr = new int[]{-1};
        }
        return arr;
    }
}