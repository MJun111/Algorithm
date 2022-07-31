#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1000000 + 1

int t, n;
long long dp[MAX];

void solution()
{
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    for (int i = 4; i < MAX; i++)
        dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1000000009;

    cin >> t;
    while (t-- > 0)
    {
        cin >> n;
        cout << dp[n] << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}