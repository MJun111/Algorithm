#include <iostream>
#include <queue>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100 + 1

int n, m;
int relation[MAX][MAX];
int KB[MAX];
vector<int> graph[MAX];

void input()
{
    cin >> n >> m;
    for (int i = 0; i < m; i++)
    {
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }
}

void BFS(int num)
{
    bool visited[MAX] = { false, };
    visited[num] = true;

    queue<int> q;
    q.push(num);

    while (!q.empty())
    {
        int cur = q.front();
        q.pop();

        for (int i = 0; i < graph[cur].size(); i++)
        {
            if (!visited[graph[cur][i]])
            {
                visited[graph[cur][i]] = true;
                q.push(graph[cur][i]);
                relation[num][graph[cur][i]] = relation[num][cur] + 1;
            }
        }
    }
}

void getKB()
{
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= n; j++)
            KB[i] += relation[i][j];
}

void solution()
{
    for (int i = 1; i <= n; i++)
        BFS(i);

    getKB();

    int ans = 1;
    for (int i = 2; i <= n; i++)
        if (KB[i] < KB[ans])
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