import java.util.Scanner;
public class BOJ_16926_배열돌리기1 {
	static int R, C;
	static int[][] map;
	static int rotateCnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R][C];
		rotateCnt = sc.nextInt();
		for (int r = 0; r < R; r++) {			 
			for (int c = 0; c < C; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		for (int cnt = 1; cnt <= rotateCnt; cnt++) {
			rotate();
		}
		for (int r = 0; r < R; r++) {			 
			for (int c = 0; c < C; c++) {
				System.out.print(map[r][c] + " "); 
			}
			System.out.println();
		}
	}

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static void rotate() {
		for (int cnt = 0, loopCnt = Math.min(R, C) / 2; cnt < loopCnt; cnt++) {
			int temp = map[cnt][cnt];
			int x = cnt;
			int y = cnt;
			for (int i = 0; i < 4; i++) {
				while (true) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx < cnt || nx >= R - cnt || ny < cnt || ny >= C - cnt) break;
					
					map[x][y] = map[nx][ny];
					
					x = nx;
					y = ny;
				}
			}
			// 마지막 위치의 값을 처리한다.
			map[cnt + 1][cnt] = temp;
		}
	}
}
