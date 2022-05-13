#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <climits>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1001

int n, m;
vector<pair<int, int>> edge[MAX];
int dist[MAX];
int dp[MAX];

void input()
{
    cin >> n >> m;
    for (int i = 0; i < m; i++)
    {
        int a, b, c;
        cin >> a >> b >> c;
        edge[a].push_back({ b, c });
        edge[b].push_back({ a, c });
    }
}

void dijkstra()
{
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({ 0, 2 });
    dist[2] = 0;
    dp[2] = 1;

    while (!pq.empty())
    {
        auto cur = pq.top();
        pq.pop();

        if (cur.first > dist[cur.second])
            continue;

        for (auto x : edge[cur.second])
        {
            int nextDis = x.second + cur.first;

            if (nextDis < dist[x.first])
            {
                dist[x.first] = nextDis;
                pq.push({ nextDis, x.first });
            }

            if (cur.first > dist[x.first])
                dp[cur.second] += dp[x.first];
        }
    }
}

void solution()
{
    fill(dist, dist + MAX, INT_MAX);

    dijkstra();
    cout << dp[1] << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}