import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        Stack<Character> st = new Stack<>();
        
        int ans = 0;
        st.push(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            // '(' : 새로운 쇠막대기 or 레이저
            if (input.charAt(i) == '(')
                st.push('(');
            
            // ')' : 레이저인지 쇠막대기인지 판별
            else {
                // 레이저였다면 스택에 들어있는 쇠막대기만큼 분할되므로 이전 '(' 괄호를 스택에서 지우고 스택의 사이즈만큼 cnt 
                if (input.charAt(i - 1) == '(') {
                    st.pop();
                    ans += st.size();
                } 
                // 쇠막대기의 끝이라면 쇠막대기 갯수를 카운트하고 삭제
                else {
                    st.pop();
                    ans++;
                }
            }
        }
        sb.append(ans);
        System.out.println(sb);
    }
}
