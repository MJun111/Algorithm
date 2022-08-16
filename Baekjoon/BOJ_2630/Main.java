import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] papers;
	static int[] ans = new int[2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		papers = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				papers[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cuttingPaper(0, 0, n);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}
	
	static void cuttingPaper(int r, int c, int size) {
		int tmp = papers[r][c];
		boolean check = true;
		for (int i = r; i < r + size; i++) 
			for (int j = c; j < c + size; j++) 
				if (tmp != papers[i][j]) {
					check = false;
					break;
				}
		
		if (check) 
			ans[tmp]++;
		else {
			size /= 2;
			
			cuttingPaper(r, c, size);
			cuttingPaper(r + size, c, size);
			cuttingPaper(r, c + size, size);
			cuttingPaper(r + size, c + size, size);
		}
	}
}
