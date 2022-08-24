import java.io.*;
import java.util.*;

/* 
 주사위 초기 도면
  2			
4 1 3 
  5			 
  6 		 
  
  동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
  주사위는 지도 위에 윗 면이 1이고, 동쪽을 바라보는 방향이 3인 상태로 놓여져 있음
 -> 아래가 6
 
 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다. 
 0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.
 
 */

public class Main {
	static int n, m, x, y, k;
	static int[][] map;
	static int[] dice = {0, 0, 0, 0, 0, 0, 0};	// 0, 1 : 위, 2 : 북 , 3 : 동, 4 : 서, 5 : 남, 6 : 아래
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		input();
		System.out.print(sb);
	}
	
	static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < m; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        // order
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) 
        	rollDice(Integer.parseInt(st.nextToken()));
        
    }
	
	static void rollDice(int order) {
		boolean isRoll = false;
		
		switch(order) {
		case 1: 
			if (x + 1 >= m) break;
			x++;
			dice = new int[] {0, dice[4], dice[2], dice[1], dice[6], dice[5], dice[3]};
			isRoll = true;
			break;
		case 2: 
			if (x - 1 < 0) break;
			x--;
			dice = new int[] {0, dice[3], dice[2], dice[6], dice[1], dice[5], dice[4]};
			isRoll = true;
			break;
		case 3: 
			if (y - 1 < 0) break;
			y--;
			dice = new int[] {0, dice[5], dice[1], dice[3], dice[4], dice[6], dice[2]}; 
			isRoll = true;
			break;
		case 4: 
			if (y + 1 >= n) break;
			y++;
			dice = new int[] {0, dice[2], dice[6], dice[3], dice[4], dice[1], dice[5]};
			isRoll = true;
			break;
		}
		
		if(!isRoll)
			return;
		
		if (map[y][x] == 0) map[y][x] = dice[6];
		else {
			dice[6] = map[y][x];
			map[y][x] = 0;
		}
		
		sb.append(dice[1] + "\n");
		
	}
}
