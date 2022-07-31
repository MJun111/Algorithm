#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1000 + 1

int n;
int arr[MAX][3];
int dp[MAX][3];

void input()
{
    cin >> n;
    for (int i = 1; i <= n; i++)
        for (int j = 0; j < 3; j++)
            cin >> arr[i][j];
}

void solution()
{
    for (int k = 0; k < 3; k++)
        dp[1][k] = arr[1][k];

    for (int i = 2; i <= n; i++)
    {
        dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
        dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
        dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
    }

    cout << min(dp[n][0], min(dp[n][1], dp[n][2])) << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}