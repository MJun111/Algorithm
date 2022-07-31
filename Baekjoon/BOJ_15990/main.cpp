#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100000 + 1
#define MOD 1000000009

int t, n;
long long dp[MAX][4];           // [n][1] : n을 나타낼 때 마지막 자리에 1이 오는 경우

void solution()
{
    dp[1][1] = 1;
    dp[2][2] = 1;
    dp[3][1] = 1;
    dp[3][2] = 1;
    dp[3][3] = 1;

    for (int i = 4; i < MAX; i++)
    {
        dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
        dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
        dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
    }

    cin >> t;
    while (t-- > 0)
    {
        cin >> n;
        long long ans = (dp[n][1] + dp[n][2] + dp[n][3]) % MOD;
        cout << ans << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}