#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100000 + 1

int n, m;
int a[MAX], b[MAX];

void input()
{
	cin >> n;
	for (int i = 1; i <= n; i++)
		cin >> a[i];
	
	cin >> m;
	for (int i = 1; i <= m; i++)
		cin >> b[i];
}

int main()
{
	input();
	sort(a + 1, a + n + 1);
	
	for (int i = 1; i <= m; i++)
	{
		bool check = false;
		int L = 1;
		int R = n;

		while (L <= R)
		{
			int M = (L + R) / 2;
			if (b[i] < a[M])
				R = M - 1;
			else if (b[i] > a[M])
				L = M + 1;
			else if (b[i] == a[M])
			{
				check = true;
				break;
			}
		}
		cout << check << "\n";
	}
	
	return 0;
}