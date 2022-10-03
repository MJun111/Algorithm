package com.ssafy.day1001.problem;
import java.io.*;
import java.util.*;

/*
 * 사람 좌표, 계단 좌표, 길이를 저장한 후 부분집합으로 사람마다 계단1 or 계단2를 선택하는 경우 대입
 * 
 * 메모리 : 33,432 kb
 * 실행시간 : 125 ms
 * 코드길이 : 3,173
 */

public class SWEA_2383 {
	static class Person {
		int r, c;
		Person(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int n, size, ans;
	static ArrayList<Person> list;
	static PriorityQueue<Integer> stair1, stair2;
	static int sr1, sc1, len1, sr2, sc2, len2;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/2383_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			ans = Integer.MAX_VALUE;
			list = new ArrayList<>();
			
			boolean flag = false;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					if (tmp > 1) {
						if (!flag) {
							sr1 = i;
							sc1 = j;
							len1 = tmp;
							flag = true;
						} else {
							sr2 = i;
							sc2 = j;
							len2 = tmp;
						}
					} else if (tmp == 1) {
						list.add(new Person(i, j));
					}
				}
			}
			size = list.size();
			isSelected = new boolean[size];
			
			subset(0);
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.print(sb);
	}
	
	static void subset(int index) {
		if (index == size) {
			stair1 = new PriorityQueue<>();
			stair2 = new PriorityQueue<>();
			
			for (int i = 0; i < size; i++) {
				Person p = list.get(i);
				if (isSelected[i]) {
					stair1.add(distance(p.r, p.c, sr1, sc1));
				} else {
					stair2.add(distance(p.r, p.c, sr2, sc2));
				}
			}
			
			simulation();
			return;
		}
		
		isSelected[index] = true;
		subset(index + 1);
		isSelected[index] = false;
		subset(index + 1);
	}
	
	static void simulation() {
		ArrayList<Integer> endTime = new ArrayList<>();
		int cnt = 0;
		while (!stair1.isEmpty()) {
			int cur = stair1.poll();
			// 대기 X
			if (endTime.size() < 3) {
				endTime.add(cur + len1 + 1);
				cnt++;
				continue;
			}
			
			// 도착 시간이 계단을 이용 중인 사람의 끝나는 시간보다 늦다면
			if (cur >= endTime.get(cnt - 3)) {
				endTime.add(cur + len1 + 1);
			}
			// 대기해야 한다면
			else {
				endTime.add(len1 + endTime.get(cnt - 3));
			}
			cnt++;
		}
		
		int end1 = 0;
		if (cnt != 0)
			end1 = endTime.get(cnt - 1);
		
		endTime = new ArrayList<>();
		cnt = 0;

		while (!stair2.isEmpty()) {
			int cur = stair2.poll();
			// 대기 X
			if (endTime.size() < 3) {
				endTime.add(cur + len2 + 1);
				cnt++;
				continue;
			}
			
			// 도착 시간이 계단을 이용 중인 사람의 끝나는 시간보다 늦다면
			if (cur >= endTime.get(cnt - 3)) {
				endTime.add(cur + len2 + 1);
			}
			// 대기해야 한다면
			else {
				endTime.add(len2 + endTime.get(cnt - 3));
			}
			cnt++;
		}
		
		int end2 = 0;
		if (cnt != 0)
			end2 = endTime.get(cnt - 1);
		
		// end1과 end2 중 도착시간이 큰 값이 총 걸린 시간, ans값과 비교하여 걸린 시간이 적은 값으로 갱신
		int res = Math.max(end1, end2);
		ans = Math.min(ans, res);
	}

	static int distance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
}
