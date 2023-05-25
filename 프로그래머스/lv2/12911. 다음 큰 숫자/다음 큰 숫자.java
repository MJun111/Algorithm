class Solution {
    public static int toBinary(int n) {
        if (n < 1) return 0;
        
        return n % 2 + toBinary(n / 2);
    }
    
    public int solution(int n) {
        int cnt = toBinary(n);
        while (true) {
            if (toBinary(++n) == cnt) return n;
        }
    }
}