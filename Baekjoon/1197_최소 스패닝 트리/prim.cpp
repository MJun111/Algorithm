#include <iostream>
#include <vector>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

// prim
int visited[10001];
vector<pair<int, int>> edge[10001];

void prim()
{
	long long ans = 0;
	priority_queue <pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push({ 0, 1 });

	while (!pq.empty())
	{
		pair<int, int> cur = pq.top();
		pq.pop();

		if (visited[cur.second])
			continue;

		visited[cur.second] = 1;

		ans += cur.first;

		for (int i = 0; i < edge[cur.second].size(); i++)
			if (!visited[edge[cur.second][i].second])
				pq.push(edge[cur.second][i]);
	}

	cout << ans;
}

int main() 
{
	FAST
	int v, e, a, b, c;
	
	cin >> v >> e;

	for (int i = 0; i < e; i++)
	{
		cin >> a >> b >> c;
		edge[a].push_back({ c, b });
		edge[b].push_back({ c, a });
	}

	prim();

	return 0;
}
