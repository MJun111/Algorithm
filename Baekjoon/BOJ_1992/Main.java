import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < n; j++) 
				arr[i][j] = str.charAt(j) - '0';
		}
		
		seperate(0, 0, n);
		System.out.println(sb);
		
	}
	
	static void seperate(int y, int x, int n) {
		if (n == 1) {
			sb.append(arr[y][x]);
			return;
		}
		
		boolean flag = true;
		int tmp = arr[y][x];
		outer : for (int i = y; i < y + n; i++) {
			for (int j = x; j < x + n; j++) {
				if (tmp != arr[i][j]) {
					flag = false;
					break outer;
				}
			}
		}
		
		if (flag) {
			sb.append(tmp);
		}
		else {
			n /= 2;
			sb.append('(');
			seperate(y, x, n);
			seperate(y, x + n, n);
			seperate(y + n, x, n);
			seperate(y + n, x + n, n);
			sb.append(')');
		}
	}
	
}
