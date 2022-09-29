import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n + 1][3];
		int[][] dp = new int[n + 1][3];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 색 별 1번째 집 초기값 설정
		for (int j = 0; j < 3; j++) {
			dp[1][j] = arr[1][j];
		}
		
		// 조건에 맞게 상향식으로 dp배열 채워감
		for (int i = 2; i <= n; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
			dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + arr[i][2];
		}
		
		// n번째 최솟값 출력
		System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
	}
}
