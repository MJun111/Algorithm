class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append(' ');
                continue;
            }
            
            if (Character.isUpperCase(s.charAt(i))) {
                if (s.charAt(i) + n > 'Z') {
                    sb.append((char)('A' + (s.charAt(i) + n) - 'Z' - 1));
                } else {
                    sb.append((char)(s.charAt(i) + n));
                }
            } else {
                if (s.charAt(i) + n > 'z') {
                    sb.append((char)('a' + (s.charAt(i) + n) - 'z' - 1));
                } else {
                    sb.append((char)(s.charAt(i) + n));
                }
            }
        }
        
        return sb.toString();
    }
}