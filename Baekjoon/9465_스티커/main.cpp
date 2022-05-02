#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100000 + 1

int t, n;
int arr[MAX][2];
int dp[MAX][2];

void input()
{
    cin >> n;
    for (int i = 1; i <= n; i++)
        cin >> arr[i][0];
    for (int i = 1; i <= n; i++)
        cin >> arr[i][1];
}

void solution()
{
    cin >> t;
    while (t-- > 0)
    {
        memset(arr, 0, sizeof(arr));
        memset(dp, 0, sizeof(dp));
        input();

        dp[1][0] = arr[1][0];
        dp[1][1] = arr[1][1];

        for (int i = 2; i <= n; i++)
        {
            dp[i][0] = max(dp[i - 1][1], dp[i - 2][1]) + arr[i][0];
            dp[i][1] = max(dp[i - 1][0], dp[i - 2][0]) + arr[i][1];
        }
        cout << max(dp[n][0], dp[n][1]) << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}