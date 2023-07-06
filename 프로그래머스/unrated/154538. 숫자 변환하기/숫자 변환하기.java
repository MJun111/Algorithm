import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] dp = new int[3000001];
        Arrays.fill(dp, 987654321);
        
        dp[x] = 0;
        dp[x + n] = 1;
        dp[x * 2] = 1;
        dp[x * 3] = 1;
        
        for (int i = x + 1; i <= y; i++) {
            int min = 987654321;
            if (i - n > 0) {
                min = Math.min(dp[i - n], min);
            }
            if (i % 2 == 0) {
                min = Math.min(dp[i / 2], min);
            }
            if (i % 3 == 0) {
                min = Math.min(dp[i / 3], min);
            }
            dp[i] = min + 1;
        }
        
        if (dp[y] > 10000)
            return -1;
        
        return dp[y];
    }
}