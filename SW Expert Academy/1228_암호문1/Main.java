import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());

			ArrayList<String> origin = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) 
				origin.add(st.nextToken());
			
			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				String order = st.nextToken();
				if (order.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					Stack<String> nums = new Stack<>();
					
					for (int i = 0; i < y; i++) 
						nums.add(st.nextToken());

					for (int i = 0; i < y; i++) {
						origin.add(x, nums.pop());
					}
				}
			}
			sb.append("#" + tc + " ");
			for (int i = 0; i < 10; i++) 
				sb.append(origin.get(i)).append(" ");
			
			System.out.println(sb);
		}
		
	}
}
