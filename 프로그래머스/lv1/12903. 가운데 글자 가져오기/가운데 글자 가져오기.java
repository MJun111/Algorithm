class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        if (s.length() % 2 == 0) {
            sb.append(s.charAt(len / 2 - 1)).append(s.charAt(len / 2));
            return sb.toString();
        } 
        return sb.append(s.charAt(len / 2)).toString();
    }
}