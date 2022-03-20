#include <iostream>
#include <vector>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define INF 987654321

int n, m, sp, ep;
int d[1001];
vector<pair<int, int>> node[1001];

void Dijkstra(int sp)
{
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push({ sp, 0 });				// 도시, 비용

	while (!pq.empty())
	{
		int cur = pq.top().first;	// cur : current, 현재 도시
		int cost = pq.top().second;	// cost : 비용
		pq.pop();

		if (cost > d[cur])
			continue;

		for (int i = 0; i < node[cur].size(); i++)
		{
			int next = node[cur][i].first;
			int next_cost = d[cur] + node[cur][i].second;

			if (next_cost < d[next])
			{
				d[next] = next_cost;
				pq.push({ next, next_cost });
			}
		}
	}


}

int main() {
	FAST

	cin >> n >> m;
	for (int i = 0; i < m; i++)
	{
    		int a, b, c;
		cin >> a >> b >> c;
		node[a].push_back({ b, c });	// a : 출발 도시, b : 도착 도시, c : 비용
	}
	cin >> sp >> ep;

	fill_n(d, 1001, INF);
	d[sp] = 0;
	Dijkstra(sp);

	cout << d[ep];
	
	return 0;
}
