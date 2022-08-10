import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] map = new int[102][102];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					map[x + j][y + k]++;
				}
			}
		}
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};

		int ans = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (map[i][j] >= 1) {
					for (int k = 0; k < 4; k++) {
						int nr = i + dy[k];
						int nc = j + dx[k];
						
						if (nr < 0 || nc < 0 || nr > 101 || nc > 101) continue;
						if (map[nr][nc] == 0)
							ans++;
					}
				}
			}
		}
		
		System.out.println(ans);
	}
	
}
