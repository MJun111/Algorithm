class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[100000][4];
        
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];   
        }
        
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int tmp = 0;
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    tmp = Math.max(tmp, dp[i - 1][k]);
                }
                dp[i][j] = tmp + land[i][j];
            }
        }
        
        for (int i = 0; i < 4; i++) {
            answer = Math.max(dp[land.length - 1][i], answer);
        }

        return answer;
    }
}