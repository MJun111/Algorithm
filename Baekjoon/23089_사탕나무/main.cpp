#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100000 + 1

int n, k;
vector<int> edge[MAX];
bool visited[MAX];
int dp[MAX][21];
int parent[MAX], tmp[MAX];
queue<int> order;

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

void solve()
{
    for (int i = 1; i <= n; i++)
        for (int j = 2; j <= k; j++)
            for (int x = 0; x < edge[i].size(); x++)
            {
                int next = edge[i][x];
                dp[i][j] += (dp[next][j - 1] - dp[i][j - 2]);
            }
}

void solution()
{
    for (int i = 1; i <= n; i++)
    {
        dp[i][0] = 1;
        dp[i][1] = edge[i].size() + 1;
    }

    solve();

    int ans = dp[1][k];
    for (int i = 2; i <= n; i++)
        ans = max(ans, dp[i][k]);

    cout << ans << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}