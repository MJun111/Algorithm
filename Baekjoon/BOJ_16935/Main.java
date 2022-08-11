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
		
		int order;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < r; i++) {
			order = Integer.parseInt(st.nextToken());
			calc(order);
		}
		
		printArray(arr);
	}
	
	static void calc(int order) {
		switch(order) {
		case 1: calc1(); break;
		case 2: calc2(); break;
		case 3: calc3(); break;
		case 4: calc4(); break;
		case 5: calc5(); break;
		case 6: calc6(); break;
		}
	}
	
	static void calc1() {
		int n = arr.length - 1;
		int m = arr[1].length - 1;
		int[][] tmp = copyArray(arr);
		
		for (int i = 1; i <= n; i++) 
			for (int j = 1; j <= m; j++) 
				tmp[i][j] = arr[n - i + 1][j];
			
		arr = tmp;
	}
	
	static void calc2() {
		int n = arr.length - 1;
		int m = arr[1].length - 1;
		int[][] tmp = copyArray(arr);
		
		for (int i = 1; i <= n; i++) 
			for (int j = 1; j <= m; j++) 
				tmp[i][j] = arr[i][m - j + 1];
		
		arr = tmp;
	}
	
	static void calc3() {
		int n = arr.length - 1;
		int m = arr[1].length - 1;
		int[][] tmp = new int[m + 1][n + 1];
		
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++)
				tmp[i][j] = arr[n - j + 1][i];
		
		arr = tmp;
	}
	
	static void calc4() {
		int n = arr.length - 1;
		int m = arr[1].length - 1;
		int[][] tmp = new int[m + 1][n + 1];
		
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++) 
				tmp[i][j] = arr[j][m - i + 1];
		
		arr = tmp;
	}
	
	static void calc5() {
		int n = arr.length - 1;
		int m = arr[1].length - 1;
		int[][] tmp = new int[n + 1][m + 1];
		
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++) {
				if (i <= n/2) {
					if (j <= m/2)
						tmp[i][j] = arr[n/2 + i][j];
					else
						tmp[i][j] = arr[i][j - m/2];
				}
				else {
					if (j <= m/2)
						tmp[i][j] = arr[i][m/2 + j];
					else
						tmp[i][j] = arr[i - n/2][j];
				}
				
			}
		arr = tmp;
		
	}
	
	static void calc6() {
		int n = arr.length - 1;
		int m = arr[1].length - 1;
		int[][] tmp = new int[n + 1][m + 1];
		
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++) {
				if (i <= n/2) {
					if (j <= m/2)
						tmp[i][j] = arr[i][m/2 + j];
					else
						tmp[i][j] = arr[n/2 + i][j];
				}
				else {
					if (j <= m/2)
						tmp[i][j] = arr[i - n/2][j];
					else
						tmp[i][j] = arr[i][j - m/2];
				}
				
			}
		arr = tmp;
		
	}
	
	static int[][] copyArray(int[][] origin) {
		int n = arr.length - 1;
		int m = arr[1].length - 1;
		int[][] res = new int[n + 1][m + 1];
		
		for (int i = 1; i <= n; i++)
			System.arraycopy(origin[i], 1, res[i], 1, m);
		
		return res;
	}
	
	static void printArray(int[][] array) {
		for (int i = 1; i <= array.length - 1; i++) {
			for (int j = 1; j <= array[0].length - 1; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}
