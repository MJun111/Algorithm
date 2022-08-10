import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		boolean[][] map = new boolean[101][101];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					map[x + j][y + k] = true;
				}
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= 100; i++)
			for (int j = 1; j <= 100; j++)
				if (map[i][j])
					ans++;
		
		System.out.println(ans);
	}
}
