#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 4000 + 1
#define INF 987654321

int n, m;
vector<pair<int, int>> edge[MAX];
int dist[MAX][3];       // 0 : ¿©¿ì, 1 : ´Á´ë °ÉÀ½, 2 : ´Á´ë ¶Ü

void input()
{
    cin >> n >> m;
    for (int i = 1; i <= m; i++)
    {
        int a, b, d;
        cin >> a >> b >> d;
        edge[a].push_back({ b, d });
        edge[b].push_back({ a, d });
    }
}

void Dijkstra_fox()
{
    priority_queue<pair<int, int>> pq;
    pq.push({ 0, 1 });
    dist[1][0] = 0;
    int fs = 2;

    while (!pq.empty())
    {
        int cur_node = pq.top().second;
        int cur_dist = -pq.top().first;
        pq.pop();

        for (int i = 0; i < edge[cur_node].size(); i++)
        {
            int next_node = edge[cur_node][i].first;
            int next_dist = cur_dist + fs * edge[cur_node][i].second;
            
            if (next_dist < dist[next_node][0])
            {
                dist[next_node][0] = next_dist;
                pq.push({ -next_dist, next_node });
            }
        }
    }
}

void Dijkstra_wolf()
{
    priority_queue<pair<pair<int, int>, int>> pq;
    pq.push(make_pair(make_pair(0, 1), 0));         // dist, node, state
    int ws[2] = { 4, 1 };

    while (!pq.empty())
    {
        int cur_node = pq.top().first.second;
        int cur_dist = -pq.top().first.first;
        int state = pq.top().second;
        pq.pop();

        if (dist[cur_node][state % 2 + 1] < cur_dist)       // ¿©·¯¹ø ¹æ¹® ¹æÁö
            continue;

        for (int i = 0; i < edge[cur_node].size(); i++)
        {
            int next_node = edge[cur_node][i].first;
            int next_dist = cur_dist + ws[(state + 1) % 2] * edge[cur_node][i].second;

            if (next_dist < dist[next_node][(state + 1) % 2 + 1])
            {
                dist[next_node][(state + 1) % 2 + 1] = next_dist;
                pq.push(make_pair(make_pair(-next_dist, next_node), (state + 1) % 2));
            }
        }
    }
}

void distSet()
{
    for (int i = 1; i <= n; i++)
    {
        dist[i][0] = INF;
        dist[i][1] = INF;
        dist[i][2] = INF;
    }
}

void solution()
{
    distSet();
    Dijkstra_fox();
    Dijkstra_wolf();

    int ans = 0;
    for (int i = 2; i <= n; i++)
        if (dist[i][0] < min(dist[i][1], dist[i][2]))
            ans++;

    cout << ans << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}