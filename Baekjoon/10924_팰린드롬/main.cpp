#include <iostream>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 2001

int n, m;
int arr[MAX];
int dp[MAX][MAX];

void input()
{
    cin >> n;
    for (int i = 1; i <= n; i++)
        cin >> arr[i];
}

void solution()
{
    for (int i = 1; i <= n; i++)
    {
        dp[i][i] = 1;
        if (arr[i - 1] == arr[i])
            dp[i - 1][i] = 1;
    }

    for (int i = 2; i < n; i++)
    {
        for (int j = 1; j <= n; j++)
            if (arr[j] == arr[i + j] && dp[j + 1][j + i - 1])
                dp[j][j + i] = 1;
    }

    cin >> m;
    while (m-- > 0)
    {
        int s, e;
        cin >> s >> e;
        cout << dp[s][e] << "\n";
    }
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}