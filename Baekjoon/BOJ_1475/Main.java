import java.util.*;
import java.io.*;

// N < 백만, 자연수
// 한 세트 0 ~ 9 하나씩, 6과 9는 뒤집어서 사용 가능 -> 6과 9를 같은것으로 취급
// 필요한 개수 출력
public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int[] nums = new int[11];
        
        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
        	nums[input.charAt(i) - '0']++;
        }
        
        int tmp = nums[6] + nums[9] + 1;
        nums[6] = tmp / 2;
        nums[9] = tmp / 2;
        
        int max = 0;
        for (int n : nums)
        	max = max > n ? max : n;
        
        sb.append(max);
        System.out.println(sb);
    }
}
