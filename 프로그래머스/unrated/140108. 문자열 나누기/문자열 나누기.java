class Solution {
    public int solution(String s) {
        int answer = 1;
        
        char c = s.charAt(0);
        int l1 = 1;
        int l2 = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == c) {
                l1++;
            } else {
                l2++;
            }
            
            if (l1 == l2) {
                answer++;
                c = s.charAt(i + 1);
                l1 = 0;
                l2 = 0;
            }
        }
        
        return answer;
    }
}