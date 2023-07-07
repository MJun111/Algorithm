class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
            int amount = getGcdCnt(i);
            if (amount > limit) {
                answer += power;
            } else {
                answer += amount;
            }
        }
        
        return answer;
    }
    
    public int getGcdCnt(int num) {
        int cnt = 0;
        
        for (int i = 1; i * i <= num; i++) {
            if (i * i == num) cnt++;
            else if (num % i == 0) cnt += 2;
        }
        
        return cnt;
    }
}