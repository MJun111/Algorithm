class Solution {
    
    public int getGcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return getGcd(b, a % b);
    }
    
    public int getLcm(int a, int b) {
        return a * b / getGcd(a, b);
    }
    
    public int solution(int[] arr) {
        int answer = 0;
        
        int a = arr[0];
        int b = 1;
        for (int i = 1; i < arr.length; i++) {
            b = arr[i];
            a = a >= b ? getLcm(a, b) : getLcm(b, a);
        }
        
        return a;
    }
}