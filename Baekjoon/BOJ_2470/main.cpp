#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100000 + 1

int n;
int arr[MAX];
void input()
{
	cin >> n;
	for (int i = 1; i <= n; i++)
		cin >> arr[i];
}

int lower_bound(int L, int R, int num)
{
	int res = n + 1;

	while (R > L)
	{
		int M = (L + R) / 2;

		if (arr[M] >= num)
		{
			res = M;
			R = M - 1;
		}
		else
			L = M + 1;
	}
	return res;
}

int main()
{
	FAST
	input();

	sort(arr + 1, arr + 1 + n);

	int b_sum = 2000000000 + 1;
	int v1 = 0, v2 = 0;

	for (int left = 1; left <= n - 1; left++)
	{
		int res = lower_bound(left + 1, n, -arr[left]);

		if (left + 1 <= res - 1 && res - 1 <= n && abs(arr[res - 1] + arr[left]) < abs(b_sum))
		{
			b_sum = arr[res - 1] + arr[left];
			v1 = arr[left];
			v2 = arr[res - 1];
		}
		if (left + 1 <= res && res <= n && abs(arr[res] + arr[left]) < abs(b_sum))
		{
			b_sum = arr[res] + arr[left];
			v1 = arr[left];
			v2 = arr[res];
		}
	}
	cout << v1 << " " << v2 << "\n";
	return 0;
}