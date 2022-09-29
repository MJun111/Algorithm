import java.io.*;
import java.util.*;

/*
 * 메모리 : 29,464 kb
 * 실행시간 : 115 ms
 * 코드길이 : 3,433
 */

public class Main {
	static int n, l, ans;
    static int[][] map;
    static boolean[][] incline;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/4014_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
	        l = Integer.parseInt(st.nextToken());
	        ans = 0;
	        
	        map = new int[n][n];
	        for (int i = 0; i < n; i++) {
	            st = new StringTokenizer(br.readLine());
	            for (int j = 0; j < n; j++) {
	                map[i][j] = Integer.parseInt(st.nextToken());
	            }
	        }
			
	        incline = new boolean[n][n];
	        for (int i = 0; i < n; i++) {
	            checkRow(i);
	        }

	        incline = new boolean[n][n];
	        for (int i = 0; i < n; i++) {
	            checkCol(i);
	        }
	        sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.print(sb);
	}
	
	static void checkRow(int row) {
        int value = map[row][0];
        for (int i = 1; i < n; i++) {
            if (value != map[row][i]) {
                if (Math.abs(value - map[row][i]) > 1) return;

                // 올라가는 경사로
                if (value < map[row][i]) {
                    if (i - l < 0) return;

                    for (int j = i - l; j < i; j++) {
                        if (!incline[row][j] && map[row][j] == value) {
                            incline[row][j] = true;
                        }
                        else return;
                    }

                    value++;
                }
                // 내려가는 경사로
                else {
                    if (i + l > n) return;

                    for (int j = i; j < i + l; j++) {
                        if (!incline[row][j] && map[row][j] == value - 1) {
                            incline[row][j] = true;
                        }
                        else return;
                    }
                    i += l - 1;
                    value--;
                }
            }

        }
        ans++;
    }

    static void checkCol(int col) {
        int value = map[0][col];
        for (int i = 1; i < n; i++) {
            if (value != map[i][col]) {
                if (Math.abs(value - map[i][col]) > 1) return;

                // 올라가는 경사로
                if (value < map[i][col]) {
                    if (i - l < 0) return;

                    for (int j = i - l; j < i; j++) {
                        if (!incline[j][col] && map[j][col] == value) {
                            incline[j][col] = true;
                        }
                        else return;
                    }

                    value++;
                }
                // 내려가는 경사로
                else {
                    if (i + l > n) return;

                    for (int j = i; j < i + l; j++) {
                        if (!incline[j][col] && map[j][col] == value - 1) {
                            incline[j][col] = true;
                        }
                        else return;
                    }
                    i += l - 1;
                    value--;
                }
            }

        }
        ans++;
    }

}
