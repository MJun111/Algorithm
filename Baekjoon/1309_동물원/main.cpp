#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100000 + 1
#define MOD 9901

int n;
int dp[MAX][3];

void input()
{
    cin >> n;
}

void solution()
{
    dp[1][0] = 1;           // 미배치
    dp[1][1] = 1;           // 왼
    dp[1][2] = 1;           // 오

    for (int i = 2; i <= n; i++)
    {
        dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
        dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
        dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
    }
    cout << (dp[n][0] + dp[n][1] + dp[n][2]) % MOD << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}