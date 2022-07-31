#include <iostream>
#include <vector>
#include <cstring>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100000 + 1

int n, k;
vector<int> edge[MAX];
int dp[21][MAX];

void input()
{
    cin >> n >> k;
    for (int i = 1; i <= n - 1; i++)
    {
        int u, v;
        cin >> u >> v;
        edge[u].push_back(v);
        edge[v].push_back(u);
    }
}

void solution()
{
    for (int i = 1; i <= n; i++)
    {
        dp[0][i] = 1;
        dp[1][i] = edge[i].size() + 1;
    }

    for (int i = 2; i <= k; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            for (int x = 0; x < edge[j].size(); x++)
            {
                int next = edge[j][x];
                dp[i][j] += dp[i-1][next];
            }
            dp[i][j] -= (dp[i-2][j] * (edge[j].size() - 1));
        }
    }

    int ans = 0;
    for (int i = 1; i <= n; i++)
        ans = max(ans, dp[k][i]);

    cout << ans << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}