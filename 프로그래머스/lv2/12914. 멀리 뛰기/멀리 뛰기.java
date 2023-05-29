class Solution {
    public long solution(int n) {
        long dp[] = new long[2001];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= 2000; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }
        
        return dp[n];
    }
    
}