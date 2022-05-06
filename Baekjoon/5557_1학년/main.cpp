#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100 + 1

int n;
int arr[MAX];
long long dp[MAX][21];

void input()
{
    cin >> n;
    for (int i = 1; i <= n; i++)
        cin >> arr[i];
}

void solution()
{
    dp[1][arr[1]]++;
    for (int i = 2; i <= n; i++)
        for (int j = 0; j <= 20; j++)
            if (dp[i - 1][j])
            {
                if (j + arr[i] <= 20)
                    dp[i][j + arr[i]] += dp[i - 1][j];
                if (j - arr[i] >= 0)
                    dp[i][j - arr[i]] += dp[i - 1][j];
            }

    cout << dp[n - 1][arr[n]] << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}