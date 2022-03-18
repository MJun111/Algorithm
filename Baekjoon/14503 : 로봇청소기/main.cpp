#include <iostream>
using namespace std;

int main() {
	int n, m, r, c, d;
	int cnt = 0;
	int rot = 0;
	bool isFin = false;
	
	cin >> n >> m;
	cin >> r >> c >> d;
	
	int map[n][m];
	
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> map[i][j];
		}
	}
	
	while(1)
	{
		if (isFin)
		{
			break;
		}
		
		if (map[r][c] == 0)
		{
			cnt++;
			map[r][c] = 2;
		}	
		
		if (d == 0)
		{
			if (rot >= 4)
			{
				if (map[r+1][c] == 1)
				{
					isFin = true;
					break;
				}
				else
				{
					r++;
					rot = 0;
				}
			}
			d = 3;
			rot++;
			if (map[r][c-1] < 1)
			{
				c--;
				rot = 0;
			}
		}
		else if (d == 1)
		{
			if (rot >= 4)
			{
				if (map[r][c-1] == 1)
				{
					isFin = true;
					break;
				}
				else
				{
					c--;
					rot = 0;
				}
			}
			d = 0;
			rot++;
			if (map[r-1][c] < 1)
			{
				r--;
				rot = 0;
			}
		}
		else if (d == 2)
		{
			if (rot >= 4)
			{
				if (map[r-1][c] == 1)
				{
					isFin = true;
					break;
				}
				else
				{
					r--;
					rot = 0;
				}
			}
			d = 1;
			rot++;
			if (map[r][c+1] < 1)
			{
				c++;
				rot = 0;
			}
		}
		else if (d == 3)
		{
			if (rot >= 4)
			{
				if (map[r][c+1] == 1)
				{
					isFin = true;
					break;
				}
				else
				{
					c++;
					rot = 0;
				}
			}
			d = 2;
			rot++;
			if (map[r+1][c] < 1)
			{
				r++;
				rot = 0;
			}
		}
		
	}
	
	cout << cnt << endl;
	return 0;
}
