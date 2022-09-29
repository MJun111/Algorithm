import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dp = new int[1000001];
		int x = Integer.parseInt(br.readLine());
		
		for (int i = 2; i <= x; i++)
		{
			dp[i] = dp[i - 1] + 1;
			if (i % 2 == 0) {
				if (dp[i] > dp[i/2] + 1)
					dp[i] = dp[i/2] + 1;
			}
			if (i % 3 == 0) {
				if (dp[i] > dp[i/3] + 1)
					dp[i] = dp[i/3] + 1;
			}
		}
		System.out.println(dp[x]);
	}
}
