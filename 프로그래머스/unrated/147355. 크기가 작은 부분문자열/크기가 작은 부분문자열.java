class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pSize = p.length();
        int tSize = t.length() - pSize;
        for (int i = 0; i <= tSize; i++) {
            if (Long.parseLong(t.substring(i, i + pSize)) <= Long.parseLong(p)) {
                answer++;
               }
        }
        
        return answer;
    }
}