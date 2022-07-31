#include <iostream>
#include <vector>
#include <cstring>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1000 + 1

int n, m;
vector<pair<int, int>> tree[MAX];
bool visited[MAX];

void input()
{
    cin >> n >> m;
    for (int i = 1; i <= n - 1; i++)
    {
        int a, b, c;
        cin >> a >> b >> c;
        tree[a].push_back({ b, c });
        tree[b].push_back({ a, c });
    }
}

void DFS(int x1, int x2, int dist)
{
    if (x1 == x2)
    {
        cout << dist << "\n";
        return;
    }

    for (int i = 0; i < tree[x1].size(); i++)
    {
        if (!visited[tree[x1][i].first])
        {
            visited[tree[x1][i].first] = true;
            DFS(tree[x1][i].first, x2, dist + tree[x1][i].second);
        }
    }
}

void solution()
{
    for (int i = 1; i <= m; i++)
    {
        memset(visited, false, sizeof(visited));
        int x1, x2;
        cin >> x1 >> x2;
        visited[x1] = true;
        DFS(x1, x2, 0);
    }
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}