class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (int i = 0; i < babbling.length; i++) {
            boolean flag = true;
            String last = "";
            for (int j = 0; j < babbling[i].length(); j++) {
                char c = babbling[i].charAt(j);
                switch(c) {
                    case 'a':
                        if (j + 2 >= babbling[i].length()
                           || !babbling[i].substring(j, j + 3).equals("aya")
                           || babbling[i].substring(j, j + 3).equals(last)
                        ) {
                            flag = false;
                        } else {
                            last = "aya";
                            j += 2;
                        }
                        break;
                    case 'y':
                        if (j + 1 >= babbling[i].length()
                           || !babbling[i].substring(j, j + 2).equals("ye")
                           || babbling[i].substring(j, j + 2).equals(last)
                        ) {
                            flag = false;
                        } else {
                            last = "ye";
                            j += 1;
                        }
                        break;
                    case 'w':
                        if (j + 2 >= babbling[i].length()
                           || !babbling[i].substring(j, j + 3).equals("woo")
                           || babbling[i].substring(j, j + 3).equals(last)
                        ) {
                            flag = false;
                        } else {
                            last = "woo";
                            j += 2;
                        }
                        break;
                    case 'm':
                        if (j + 1 >= babbling[i].length()
                           || !babbling[i].substring(j, j + 2).equals("ma")
                           || babbling[i].substring(j, j + 2).equals(last)
                        ) {
                            flag = false;
                        } else {
                            last = "ma";
                            j += 1;
                        }
                        break;
                    default:
                        flag = false;
                        break;
                }
                
                if (!flag) break;
            }
            
            if (flag) answer++;
        }
        
        return answer;
    }
}