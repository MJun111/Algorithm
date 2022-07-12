#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define INF 987654321

int T;
int n, m, t, s, g, h, gh_dist;
int S[2001], G[2001], H[2001];

vector<pair<int, int>> node[2001];
vector<int> destination;

void input()
{
    cin >> n >> m >> t;
    cin >> s >> g >> h;

    for (int i = 0; i < m; i++)
    {
        int a, b, d;
        cin >> a >> b >> d;
        node[a].push_back({ b, d });
        node[b].push_back({ a, d });
    }

    for (int i = 0; i < t; i++)
    {
        int x;
        cin >> x;
        destination.push_back(x);
    }
}

void initialize()
{
    for (int i = 0; i < 2001; i++)
    {
        node[i].clear();
        S[i] = INF;
        G[i] = INF;
        H[i] = INF;
    }
    destination.clear();
}

void Dijkstra(int start, int arr[])
{
    priority_queue<pair<int, int>> pq;
    pq.push({ start, 0 });
    arr[start] = 0;

    while (!pq.empty())
    {
        int cur = pq.top().first;
        int dist = -pq.top().second;
        pq.pop();

        for (int i = 0; i < node[cur].size(); i++)
        {
            int next = node[cur][i].first;
            int nDist = node[cur][i].second;

            if (arr[next] > dist + nDist)
            {
                arr[next] = dist + nDist;
                pq.push({ next, -arr[next] });
            }
        }
    }
}

void solution()
{
    cin >> T;
    while (T-- > 0)
    {
        initialize();
        input();

        Dijkstra(s, S);
        Dijkstra(g, G);
        Dijkstra(h, H);
        gh_dist = G[h];

        sort(destination.begin(), destination.end());
        for (int i = 0; i < destination.size(); i++)
        {
            int dest = destination[i];
            if ((S[dest] == S[g] + gh_dist + H[dest]) || (S[dest] == S[h] + gh_dist + G[dest]))
                cout << dest << " ";
        }
        cout << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}