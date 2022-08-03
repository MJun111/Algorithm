import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) 
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(arr[b] - arr[a - 1]);
		}
	}
}
