class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i++ < n) {
            if (i % 2 == 0) sb.append("박");
            else sb.append("수");
        }
        return sb.toString();
    }
}