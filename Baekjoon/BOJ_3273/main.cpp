#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1000000 + 1

int n, x;
int ans = 0;
int a[MAX];
void input()
{
	cin >> n;

	for (int i = 1; i <= n; i++)
		cin >> a[i];

	cin >> x;
}

int main()
{
	FAST
	input();

	sort(a + 1, a + 1 + n);

	for (int i = 1; i <= n; i++)
	{
		if (a[i] >= x)
			break;

		int L = 1;
		int R = n;

		while (L <= R)
		{
			int M = (L + R) / 2;
			if (a[i] + a[M] < x)
				L = M + 1;
			else if (a[i] + a[M] > x)
				R = M - 1;
			else if (a[i] + a[M] == x)
			{
				ans++;
				break;
			}
		}
	}
	
	cout << ans / 2;

	return 0;
}