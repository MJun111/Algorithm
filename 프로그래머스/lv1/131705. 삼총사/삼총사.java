class Solution {
    
    static int res;
    public int solution(int[] number) {
        combi(0, 0, number, new int[3]);
        return res;
    }
    
    public void combi(int start, int depth, int[] num, int[] arr) {
        if (depth == 3) {
            if (arr[0] + arr[1] + arr[2] == 0) res++;
            return;
        }
        
        for (int i = start; i < num.length; i++) {
            arr[depth] = num[i];
            combi(i + 1, depth + 1, num, arr);
        }
    }
}