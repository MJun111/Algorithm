import java.io.*;
import java.util.*;

public class Main {
	static int k;
	static int[][] cogwheel;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		cogwheel = new int[4][8];
		for (int i = 0; i < 4; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++) {
				cogwheel[i][j] = tmp[j] - '0';
			}
		}
		
		k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			
			// 회전해야하는 자석들
			int[][] check = checkRotate(n, dir);
			for (int j = 0; j < 4; j++) {
				if (check[j][0] == 1) {
					rotate(j, check[j][1]);
				}
			}
		}
		
		// 점수 계산
		int score = 0;
		for (int i = 0; i < 4; i++) {
			if (cogwheel[i][0] == 1)
				score += (int) Math.pow(2, i);
		}
		
		System.out.println(score);
	}
	
	// n : n번째 톱니바퀴, dir : 회전 방향
	static void rotate(int n, int dir) {
		// 시계 방향
		if (dir == 1) {
			int tmp = cogwheel[n][7];
			for (int i = 7; i > 0; i--) {
				cogwheel[n][i] = cogwheel[n][i - 1];
			}
			cogwheel[n][0] = tmp;
		}
		// 반시계 방향
		else {
			int tmp = cogwheel[n][0];
			for (int i = 0; i < 7; i++) {
				cogwheel[n][i] = cogwheel[n][i + 1];
			}
			cogwheel[n][7] = tmp;
		}
	}

	static int[][] checkRotate(int n, int dir) {
		// check[n][0] = 1 -> 회전을 해야함, check[n][1] = -1 or 1 -> 회전 방향
		int[][] check = new int[4][2];

		check[n][0] = 1;
		check[n][1] = dir;

		// 왼쪽 검사
		int d = 1;
		while (n - d >= 0) {
			if (cogwheel[n - d][2] != cogwheel[n - d + 1][6]) {
				check[n - d][0] = 1;
				check[n - d][1] = dir * (int) Math.pow(-1, d);
				d++;
			} else
				break;
		}

		// 오른쪽 검사
		d = 1;
		while (n + d <= 3) {
			if (cogwheel[n + d - 1][2] != cogwheel[n + d][6]) {
				check[n + d][0] = 1;
				check[n + d][1] = dir * (int) Math.pow(-1, d);
				d++;
			} else
				break;
		}

		return check;
	}
	
}
