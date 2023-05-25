class Solution {
    String getBinaryNumber(int num, int digit) {
        String binary = getBinary(num);
        
        if (binary.length() < digit) {
            int size = digit - binary.length();
            binary = "0".repeat(size) + binary;
        }
        if (binary.length() > digit) {
            binary = binary.substring(binary.length() - digit, binary.length());
        }
        return binary;
    }
    
    String getBinary(int num) {
        if (num < 1) {
            return num % 2 == 0 ? "0" : "1";
        }
        return getBinary(num / 2) + (num % 2);
    }
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            String str1 = getBinaryNumber(arr1[i], n);
            String str2 = getBinaryNumber(arr2[i], n);
            
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str1.length(); j++) {
                if (str1.charAt(j) == '0' && str1.charAt(j) == str2.charAt(j)) {
                    sb.append(' ');
                } else {
                    sb.append('#');
                }
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}