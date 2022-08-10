import java.io.*;
import java.util.*;

public class Main {
	static int n, m, r;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		arr = new int[n + 1][m + 1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (r-- > 0) {
			int st_r = 1;
			int end_r = n;
			int st_c = 1;
			int end_c = m;
			
			while (true) {
				
				if (st_r > end_r || st_c > end_c) break;
				int[] vertex = { arr[st_r][end_c], arr[end_r][st_c], arr[end_r][end_c] };
				
				// 아래
				for (int i = end_r; i > st_r; i--) 
					arr[i][st_c] = arr[i - 1][st_c];
				
				// 오른쪽
				for (int i = end_c; i > st_c; i--) 
					arr[end_r][i] = arr[end_r][i - 1];
				arr[end_r][st_c + 1] = vertex[1];
				
				// 위
				for (int i = st_r; i < end_r - 1; i++)
					arr[i][end_c] = arr[i + 1][end_c];
				arr[end_r - 1][end_c] = vertex[2];
				
				// 왼쪽
				for (int i = st_c; i < end_c - 1; i++)
					arr[st_r][i] = arr[st_r][i + 1];
				arr[st_r][end_c - 1] = vertex[0];
				
				st_r++;
				st_c++;
				end_r--;
				end_c--;
			}
			
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
