class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        while (n != 0) {
            sb.append(n % 3);
            n /= 3;
        }
        
        String str = sb.toString();
        for (int i = 0; i < str.length(); i++) {
            answer += (str.charAt(i) - '0') * Math.pow(3, str.length() - i - 1);
        }
        
        return answer;
    }
}