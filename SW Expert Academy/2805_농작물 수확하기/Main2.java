import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA_2805_농작물수확하기2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/2805_input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int ans = 0;
			int n = sc.nextInt();
			int[][] farm = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				char[] data = sc.next().toCharArray();
				for (int j = 0; j < n; j++) {
					farm[i][j] = data[j] - '0';
				}
			}
			
			int center = n / 2;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (Math.abs(center - i) + Math.abs(center - j) <= center)
						ans += farm[i][j];
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}
