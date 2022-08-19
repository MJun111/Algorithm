import java.io.*;
import java.util.*;

/*
 * 메모리 : 22,700 kb
 * 실행 시간 : 203 ms
 * 코드 길이 : 1,726 B
 */

class Pair {
	int y, x;

	Pair(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class SWEA_2117 {
	static int n, m, ans, range;
	static ArrayList<Pair> home;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/2117_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		// 잠시 1
		for (int tc = 1; tc <= t; tc++) {
			sb.append("#" + tc + " ");

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			range = n + 1;

			home = new ArrayList<>();
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					if (map[i][j] == 1) {
						home.add(new Pair(i, j));
					}

				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int res = check(i, j);
					ans = Math.max(res, ans);
				}
			}
			sb.append(ans + "\n");
			ans = 0;
		}
		System.out.print(sb);
	}

	static int check(int r, int c) {
		int res = 1;
		for (int i = 1; i <= range; i++) {
			int cost = (i + 1) * (i + 1) + i * i;
			int homeCnt = getHomeCnt(r, c, i);
			if (cost <= homeCnt * m) 
				res = Math.max(res, homeCnt);
			
		}
		return res;
	}

	static int getHomeCnt(int r, int c, int cnt) {
		int rangeInHome = 0;
		for (int i = 0; i < home.size(); i++) {
			int hy = home.get(i).y;
			int hx = home.get(i).x;
			int dist = Math.abs(hy - r) + Math.abs(hx - c);
			
			if (dist <= cnt)
				rangeInHome++;
		}
		return rangeInHome;
	}

}
