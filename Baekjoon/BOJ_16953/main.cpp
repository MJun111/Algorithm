#include <iostream>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int a, b, cnt = 0;

void input()
{
	cin >> a >> b;
}

void calc(int x, int y)
{
	cnt++;

	if (y >= x)
	{
		if (y % 10 == 1)
			y /= 10;
		else if (y % 2 == 0)
			y /= 2;
		else
			cnt = -1;
	}
	else
		cnt = -1;

	if (x == y)
		cout << cnt + 1;
	else if (cnt == -1)
		cout << cnt;
	else
		calc(x, y);
}

void solution()
{
	calc(a, b);
}

int main(void)
{
	FAST
    input();
    solution();


    return 0;
}