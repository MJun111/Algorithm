#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 200000 + 1
#define INF 987654321

int n, e, v1, v2, pointer;
vector<pair<int, int>> edge[MAX];
int d[3][MAX];

void input()
{
    cin >> n >> e;
    for (int i = 0; i < e; i++)
    {
        int a, b, c;
        cin >> a >> b >> c;
        edge[a].push_back({ b, c });
        edge[b].push_back({ a, c });
    }
    cin >> v1 >> v2;
}

void Dijkstra(int start)
{
    d[pointer][start] = 0;
    priority_queue < pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({ start, 0 });

    while (!pq.empty())
    {
        int cur = pq.top().first;
        int dis = pq.top().second;
        pq.pop();

        if (d[pointer][cur] < dis)
            continue;

        for (int i = 0; i < edge[cur].size(); i++)
        {
            int next = edge[cur][i].first;
            int nextDis = dis + edge[cur][i].second;
            if (nextDis < d[pointer][next])
            {
                d[pointer][next] = nextDis;
                pq.push({ next, nextDis });
            }
        }
    }
    pointer++;
}

void solution()
{
    for (int i = 1; i <= n; i++)
    {
        d[0][i] = INF;
        d[1][i] = INF;
        d[2][i] = INF;
    }
    Dijkstra(1);        // d[0]
    Dijkstra(v1);       // d[1]
    Dijkstra(v2);       // d[2]

    int ans[2] = { -1, -1 };

    if (d[0][v1] != INF && d[1][v2] != INF && d[2][n] != INF)
        ans[0] = d[0][v1] + d[1][v2] + d[2][n];

    if (d[0][v2] != INF && d[1][v1] != INF && d[2][n] != INF)
        ans[1] = d[0][v2] + d[2][v1] + d[1][n];
 
    int res;

    if (ans[0] == -1 && ans[1] == -1)
        res = -1;
    else if (ans[0] != -1 && ans[1] == -1)
        res = ans[0];
    else if (ans[0] == -1 && ans[1] != -1)
        res = ans[1];
    else
        res = min(ans[0], ans[1]);

    cout << res << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}