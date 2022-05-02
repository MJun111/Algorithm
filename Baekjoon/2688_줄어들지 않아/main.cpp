#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 65

int t, n;
long long dp[MAX][10];
void solution()
{
    for (int i = 0; i < 10; i++)
        dp[1][i] = 1;

    for (int i = 1; i < MAX; i++)
        for (int j = 0; j < 10; j++)
            for (int k = j; k < 10; k++)
                dp[i][j] += dp[i - 1][k];

    cin >> t;
    while (t-- > 0)
    {
        cin >> n;

        long long ans = 0;
        for (int i = 0; i < 10; i++)
            ans += dp[n][i];

        cout << ans << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}