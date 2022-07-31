#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 50 + 1

int n, m, s;
int V[MAX];
bool dp[MAX][1001];

void input()
{
    cin >> n >> s >> m;
    for (int i = 1; i <= n; i++)
        cin >> V[i];
}

void solution()
{
    if (s + V[1] <= m)
        dp[1][s + V[1]] = true;
    if (s - V[1] >= 0)
        dp[1][s - V[1]] = true;

    for (int i = 2; i <= n; i++)
        for (int j = 0; j <= m; j++)
            if (dp[i - 1][j])
            {
                if (j + V[i] <= m)
                    dp[i][j + V[i]] = true;
                if (j - V[i] >= 0)
                    dp[i][j - V[i]] = true;
            }

    int ans = -1;
    for (int i = 0; i <= m; i++)
        if (dp[n][i])
            ans = i;

    cout << ans << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}