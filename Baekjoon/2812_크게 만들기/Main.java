import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		String nums = br.readLine();
		Stack<Integer> sk = new Stack<>();
		for (int i = 0; i < nums.length(); i++) {
			while(k > 0 && !sk.empty() && sk.peek() < nums.charAt(i) - '0') {
				sk.pop();
				k--;
			}
			sk.push(nums.charAt(i) - '0');
		}

		while(!sk.empty()) {
			if (k > 0) {
				k--;
				sk.pop();
				continue;
			}
			sb.append(sk.peek());
			sk.pop();
		}
		System.out.println(sb.reverse().toString());
	}
}
