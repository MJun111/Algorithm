package com.ssafy.day0808.problem;

import java.io.*;
import java.util.*;

public class SWEA_1228 {
	public static void main(String[] args) throws IOException {
// 		System.setIn(new FileInputStream("data/1230_input.txt"));
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
			while (st.hasMoreTokens()) {
				String order = st.nextToken();

				if (order.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					Stack<String> nums = new Stack<>();

					for (int i = 0; i < y; i++)
						nums.add(st.nextToken());

					for (int i = 0; i < y; i++) 
						origin.add(x, nums.pop());
				}

				else if (order.equals("D")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int i = 0; i < y; i++)
						origin.remove(x);
				}

				else if (order.equals("A")) {
					int y = Integer.parseInt(st.nextToken());
					Stack<String> nums = new Stack<>();

					for (int i = 0; i < y; i++)
						nums.add(st.nextToken());
					
					for (int i = 0; i < y; i++) 
						origin.add(nums.pop());
				}
			}
			sb.append("#" + tc + " ");
			for (int i = 0; i < 10; i++)
				sb.append(origin.get(i)).append(" ");

			System.out.println(sb);
		}

	}
}
