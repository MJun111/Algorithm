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

void input()
{
    cin >> n >> k;
    for (int i = 1; i <= n - 1; i++)
    {
        int u, v;
        cin >> u >> v;
        edge[u].push_back(v);
        edge[v].push_back(u);
        dp[u][1]++;
        dp[v][1]++;
        dp[i][1]++;
    }
}

int BFS(int num)
{
    queue<pair<int, int>> q;
    q.push({ num, 1 });
    memset(visited, false, n + 1);

    while (!q.empty())
    {
        int node = q.front().first;
        int dis = q.front().second;
        q.pop();

        if (dis > k)
            break;

        for (int i = 0; i < edge[node].size(); i++)
        {
            int next = edge[node][i];
            if (!visited[next])
            {
                dp[num][dis + 1] += dp[next][1] - 2;
                visited[next] = true;
                q.push({ next, dis + 1 });
            }
        }
    }

    return dp[num][k];
}

void solution()
{
    int candy = 0;
    for (int i = 1; i <= n; i++)
        candy = max(BFS(i), candy);
    
    cout << candy << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}