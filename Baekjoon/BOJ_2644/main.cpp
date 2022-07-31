#include <iostream>
#include <queue>
#include <vector>
#include <cstring>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100 + 1

int n, m;
int g1, g2;
int parent[MAX];
vector<int> child[MAX];
int dist[MAX];

void input()
{
    cin >> n;
    cin >> g1 >> g2;
    cin >> m;
    for (int i = 0; i < m; i++)
    {
        int x, y;
        cin >> x >> y;
        parent[y] = x;
        child[x].push_back(y);
    }
    memset(dist, -1, sizeof(dist));
}

void BFS()
{
    dist[g1] = 0;
    queue<int> q;
    q.push(g1);

    while (!q.empty())
    {
        int p = q.front();
        q.pop();

        // 0이 아니면 부모가 존재 && dist 초기값이면 아직 방문x
        if (parent[p] != 0 && dist[parent[p]] == -1)
        {
            q.push(parent[p]);
            dist[parent[p]] = dist[p] + 1;
        }

        // 자식들의 dist가 초기값이면 아직 방문x
        for (int i = 0; i < child[p].size(); i++)
        {
            if (dist[child[p][i]] == -1)
            {
                q.push(child[p][i]);
                dist[child[p][i]] = dist[p] + 1;
            }
        }
    }
    cout << dist[g2] << "\n";
}

void solution()
{
    BFS();
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}