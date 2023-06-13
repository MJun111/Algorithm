class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        s = s.toLowerCase();

        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            // 공백이 나오면 다음 첫 문자를 보고 바꿀 준비
            if (cur == ' ') {
                flag = true;
            } else {
                if (flag && cur >= 97 && cur <= 122) {
                    cur -= 32;
                }
                flag = false;
            }
            sb.append(cur);
        }

        answer = sb.toString();

        return answer;
    }
}