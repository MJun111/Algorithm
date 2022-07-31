#include <iostream>
#include <vector>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 500 + 1

int n, m;
vector<int> d[MAX];     // µ¿±â
bool visited[MAX];
int dist[MAX];

void input()
{
    cin >> n >> m;
    for (int i = 0; i < m; i++)
    {
        int a, b;
        cin >> a >> b;
        d[a].push_back(b);
        d[b].push_back(a);
    }
}

void BFS()
{
    visited[1] = true;
    queue<int> q;
    q.push(1);

    while (!q.empty())
    {
        int p = q.front();
        q.pop();

        for (int i = 0; i < d[p].size(); i++)
        {
            if (visited[d[p][i]]) continue;

            visited[d[p][i]] = true;
            q.push(d[p][i]);
            dist[d[p][i]] = dist[p] + 1;
        }
    }
}

void solution()
{
    BFS();

    int cnt = 0;
    for (int i = 2; i <= n; i++)
        if (dist[i] == 1 || dist[i] == 2)
            cnt++;
      
    cout << cnt << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}