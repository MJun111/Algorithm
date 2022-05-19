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

void child_candy(int num)
{
    visited[num] = true;
    order.push(num);

    for (int i = 0; i <= k; i++)
        dp[num][i] = 1;

    for (int i = 0; i < edge[num].size(); i++)
    {
        int next = edge[num][i];
        if (visited[next]) continue;
        parent[next] = num;
        child_candy(next);
        for (int j = 1; j <= k; j++)
            dp[num][j] += dp[next][j - 1];
    }
}

void parent_candy()
{
    order.pop();
    while (!order.empty())
    {
        int num = order.front();
        order.pop();

        for (int i = 0; i <= k; i++) tmp[i] = dp[num][i];
        for (int i = 1; i <= k; i++)
        {
            if (i == 1) dp[num][i] += 1;
            else dp[num][i] += dp[parent[num]][i - 1] - tmp[i - 2];
        }
    }
}

void solution()
{
    child_candy(1);
    parent_candy();

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