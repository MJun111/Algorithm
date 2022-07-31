#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 40 + 1

int t, n;
int cnt[MAX][2];        // [n][0] : 0이 나온 횟수, [n][1] : 1이 나온 횟수

void input()
{
    cin >> t;
}

void solution()
{
    // 초기값
    cnt[0][0] = 1;
    cnt[1][0] = 0;

    cnt[0][1] = 0;
    cnt[1][1] = 1;

    // fibo[n] = fibo[n - 2] + fibo[n - 1];
    for (int i = 2; i <= 40; i++)
    {
        cnt[i][0] = cnt[i - 2][0] + cnt[i - 1][0];
        cnt[i][1] = cnt[i - 2][1] + cnt[i - 1][1];
    }

    while (t-- > 0)
    {
        cin >> n;
        cout << cnt[n][0] << " " << cnt[n][1] << "\n";
    }
}

int main()
{
	FAST
	input();
    solution();

	return 0;
}