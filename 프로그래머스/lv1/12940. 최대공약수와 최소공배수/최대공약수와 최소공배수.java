class Solution {
    
    public int getGcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return getGcd(b, a % b);
    }
    
    public int[] solution(int n, int m) {
        int gcd = n >= m ? getGcd(n, m) : getGcd(m, n);
        int lcm = n * m / gcd;
        int[] answer = {gcd, lcm};
        return answer;
    }
}