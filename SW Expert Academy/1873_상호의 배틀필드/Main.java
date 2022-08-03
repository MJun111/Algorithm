package com.ssafy.day0803.problem;

import java.io.*;
import java.util.*;

/*

문자	의미
.	평지(전차가 들어갈 수 있다.)
*	벽돌로 만들어진 벽
#	강철로 만들어진 벽
-	물(전차는 들어갈 수 없다.)
^	위쪽을 바라보는 전차(아래는 평지이다.)
v	아래쪽을 바라보는 전차(아래는 평지이다.)
<	왼쪽을 바라보는 전차(아래는 평지이다.)
>	오른쪽을 바라보는 전차(아래는 평지이다.)

문자	동작
U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.

포탄 발사 시 해당 방향 직선으로 맵 밖으로 나가거나 벽에 부딪힐 때 까지 이동
벽돌 벽이라면 평지로 바뀜

*/

public class SWEA_1873_상호의배틀필드 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/1873_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			// 탱크 시작 좌표, 방향
			int ty = 0, tx = 0;
			int dir = 0;	
			
			int[] dx = {0, 0, -1, 1};
			int[] dy = {-1, 1, 0, 0};
			
			char[][] map = new char[h][w];
			for (int i = 0; i < h; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = tmp.charAt(j);
					
					char c = map[i][j];
					if (c == '^' || c == 'v' || c == '<' || c == '>') {
						ty = i;
						tx = j;
						dir = "^v<>".indexOf(c);
						map[i][j] = '.';
					}
				}
			}
			
			int n = Integer.parseInt(br.readLine());
			String order = br.readLine();
			int sy = 0;
			int sx = 0;
			for (int i = 0; i < n; i++) {
				char nowOrder = order.charAt(i);
				switch(nowOrder) {
				case 'U':
					dir = 0;
					if (ty - 1 >= 0 && map[ty - 1][tx] == '.') ty--; break;
				case 'D':
					dir = 1;
					if (ty + 1 < h && map[ty + 1][tx] == '.') ty++; break;
				case 'L':
					dir = 2;
					if (tx - 1 >= 0 && map[ty][tx - 1] == '.') tx--; break;
				case 'R':
					dir = 3;
					if (tx + 1 < w && map[ty][tx + 1] == '.') tx++; break;
				case 'S':
					sx = tx;
					sy = ty;
					while(true) {
						sx += dx[dir];
						sy += dy[dir];
						
						if (sx < 0 || sx >= w || sy < 0 || sy >= h) break;
						if (map[sy][sx] == '*') {
							map[sy][sx] = '.';
							break;
						}
						if (map[sy][sx] == '#')
							break;
					}
					break;
				}
			}

			switch(dir) {
			case 0: map[ty][tx] = '^'; break;
			case 1: map[ty][tx] = 'v'; break;
			case 2: map[ty][tx] = '<'; break;
			case 3: map[ty][tx] = '>'; break;
			}
			
			System.out.print("#" + tc + " ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
		
	}
}
