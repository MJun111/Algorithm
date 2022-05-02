#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 10000 + 1

int n;
int wine[MAX];
int dp[MAX][3];

void input()
{
    cin >> n;
    for (int i = 1; i <= n; i++)
        cin >> wine[i];
}

void solution()
{
    dp[1][1] = wine[1];
    dp[1][2] = wine[1];
    dp[2][0] = wine[1];
    dp[2][1] = wine[2];
    dp[2][2] = wine[2];

    for (int i = 3; i <= n; i++)
    {
        dp[i][0] = max(max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
        dp[i][1] = max(max(dp[i - 2][0], dp[i - 2][1]), dp[i - 2][2]) + wine[i];
        dp[i][2] = max(max(dp[i - 3][0], dp[i - 3][1]), dp[i - 3][2]) + wine[i - 1] + wine[i];
    }
    for (int i = 0; i < 3; i++)
        cout << dp[n][i] << "\n";
    //cout << max(max(dp[n][0], dp[n][1]), dp[n][2]) << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}