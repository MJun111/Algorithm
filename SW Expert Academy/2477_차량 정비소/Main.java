package com.ssafy.day1001.problem;
import java.io.*;
import java.util.*;

/*
 * - 접수창고 우선순위
 *    ① 여러 고객이 기다리고 있는 경우 고객번호가 낮은 순서대로 우선 접수한다.
 * 	  ② 빈 창구가 여러 곳인 경우 접수 창구번호가 작은 곳으로 간다.
 *
 * - 정비창고 우선순위
 *    ① 먼저 기다리는 고객이 우선한다.
 *    ② 두 명 이상의 고객들이 접수 창구에서 동시에 접수를 완료하고 정비 창구로 이동한 경우, 이용했던 접수 창구번호가 작은 고객이 우선한다.
 *    ③ 빈 창구가 여러 곳인 경우 정비 창구번호가 작은 곳으로 간다.
 *    
 *   메모리 : 43,840 kb
 *   실행시간 : 163ms
 *   코드길이 : 3,880
 */

public class SWEA_2477 {
	static class Customer {
		int no;
		int arrivalTime;
		int regiNo;
		
		Customer(int no, int arrivalTime) {
			this.no = no;
			this.arrivalTime = arrivalTime;
		}
		
		Customer(int no, int arrivalTime, int regiNo) {
			this.no = no;
			this.arrivalTime = arrivalTime;
			this.regiNo = regiNo;
		}
	}
	
	static int n, m, k, a, b, ans;
	static int[] register, repair, customer;
	static int[][] isRegi;		// [창구 번호][] 0 : 사용 중인지, 1 : 끝나는 시간 
	static int[][] isRepa;		
	static PriorityQueue<Customer> regiQ, repaQ;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/2477_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			ans = 0;
			
			register = new int[n + 1];
			repair = new int[m + 1];
			isRegi = new int[n + 1][2];
			isRepa = new int[m + 1][2];
			customer = new int[k + 1];
			regiQ = new PriorityQueue<>(new Comparator<Customer>() {
				@Override
				public int compare(Customer o1, Customer o2) {
					return o1.no - o2.no;
				}
			});
			repaQ =  new PriorityQueue<>(new Comparator<Customer>() {
				@Override
				public int compare(Customer o1, Customer o2) {
					if (o1.arrivalTime == o2.arrivalTime)
						return o1.regiNo - o2.regiNo;
					return o1.arrivalTime - o2.arrivalTime;
				}
			});
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) 
				register[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++) 
				repair[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= k; i++) 
				regiQ.add(new Customer(i, Integer.parseInt(st.nextToken())));
			
			
			simulation();
			if (ans == 0)
				ans = -1;
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.print(sb);
	}
	
	static void simulation() {

		int time = 0;
		// 접수 창구
		while (!regiQ.isEmpty()) {
			Customer c = regiQ.poll();
			
			if (c.arrivalTime > time)
				time = c.arrivalTime;
			
			// 각 접수가 끝나는 시간에 접수 창구 비우기
			for (int i = 1; i <= n; i++) {
				if (isRegi[i][0] == 1 && time >= isRegi[i][1]) {
					isRegi[i][0] = 0;
					isRegi[i][1] = 0;
				}
			}
			
			// 접수 창구가 비어있으면 접수
			boolean flag = false;
			for (int i = 1; i <= n; i++) {
				if (isRegi[i][0] == 0) {
					flag = true;
					isRegi[i][0] = 1;
					isRegi[i][1] = time + register[i];
					repaQ.add(new Customer(c.no, time + register[i], i));
					break;
				}
				
				// 모두 차있을 경우
				if (i == n) {
					regiQ.add(c);
				}
			}
			
			// 대기 고객이 있다면 동일 시간에 한 번더 진행
			if (!flag)
				time++;
		}
		
		time = 0;
		// 정비 창구
		while (!repaQ.isEmpty()) {
			Customer c = repaQ.poll();
			
			if (c.arrivalTime > time)
				time = c.arrivalTime;
			
			// 각 접수가 끝나는 시간에 접수 창구 비우기
			for (int i = 1; i <= m; i++) {
				if (isRepa[i][0] == 1 && time >= isRepa[i][1]) {
					isRepa[i][0] = 0;
					isRepa[i][1] = 0;
				}
			}
			
			// 접수 창구가 비어있으면 접수
			boolean flag = false;
			for (int i = 1; i <= m; i++) {
				if (isRepa[i][0] == 0) {
					flag = true;
					isRepa[i][0] = 1;
					isRepa[i][1] = time + repair[i];
					if (c.regiNo == a && b == i) {
						ans += c.no;
					}
					break;
				}
				
				// 모두 차있을 경우
				if (i == m) {
					repaQ.add(c);
				}
			}
			
			// 대기 고객이 있다면 동일 시간에 한 번더 진행
			if (!flag)
				time++;
		}
		
	}
}
