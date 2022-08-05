import java.io.*;
import java.util.*;

class Tower {
	int idx;
	int height;

	Tower(int idx, int height) {
		this.idx = idx;
		this.height = height;
	}
}

public class BOJ_2493_탑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		
		int[] ans = new int[n + 1];
		Stack<Tower> stack = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			while (!stack.isEmpty()) {
				if (stack.peek().height < num) 
					stack.pop();
				
				else {
					ans[i] = stack.peek().idx;
					break;
				}
			} 
			
			stack.add(new Tower(i, num));
		}
		
		for (int i = 1; i <= n; i++)
			sb.append(ans[i] + " ");
		
		System.out.println(sb);
	}
}
