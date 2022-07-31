#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 500000 + 1

int n, m;
int card[MAX], num[MAX];

void input()
{
	cin >> n;
	for (int i = 1; i <= n; i++)
		cin >> card[i];

	cin >> m;
	for (int i = 1; i <= m; i++)
		cin >> num[i];
}

// 찾는 값보다 큰 값이 나오는 첫 위치
int upper_bound(int x)
{
	int L = 1;
	int R = n;
	
	while (R > L)
	{
		int M = (L + R) / 2;

		if (card[M] > x)
			R = M;
		else
			L = M + 1;
	}

	// 찾는 값이 배열에서 가장 큰 값일 경우 (예제에선 10)
	if (R == n && card[n] == x)
		R++;

	return R;
}

// 찾는 값 이상이 나오는 첫 위치
int lower_bound(int x)
{
	int L = 1;
	int R = n;

	while (R > L)
	{
		int M = (L + R) / 2;

		if (card[M] >= x)
			R = M;
		else
			L = M + 1;
	}
	return R;
}

int main()
{
	FAST
	input();

	sort(card + 1, card + 1 + n);

	for (int i = 1; i <= m; i++)
		cout << upper_bound(num[i]) - lower_bound(num[i]) << " ";
	

	return 0;
}