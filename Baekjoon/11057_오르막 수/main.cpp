#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MOD 10007

int d[1001][11] = { 0 };	// [길이][마지막 자리 수]
int ans = 0;
int n;

void input()
{
	cin >> n;
}

void solution()
{
	for (int i = 0; i < 10; i++)
		d[1][i] = 1;

	for (int i = 2; i <= n; i++)
		for (int j = 0; j < 10; j++)
			for (int k = 0; k <= j; k++)
				d[i][j] = (d[i][j] + d[i - 1][k]) % MOD;
	
	for (int i = 0; i < 10; i++)
		ans = (ans + d[n][i]) % MOD;

	cout << ans << endl;
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}