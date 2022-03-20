#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

// kruskal
int parent[10001];

struct edge 
{
	int u, v, w;

	edge(int a, int b, int c)
	{
		u = a;
		v = b;
		w = c;
	}
};

int find(int a) 
{
	if (a == parent[a])
		return a;
	else
		return parent[a] = find(parent[a]);
}

void connect(int a, int b)
{
	a = find(a);
	b = find(b);

	parent[b] = a;
}

int _compare(edge a, edge b)
{
	return a.w < b.w;
}

int main() 
{
	FAST
	vector<edge> vec;
	int v, e, a, b, c;
	long long ans = 0;

	cin >> v >> e;

	for (int i = 1; i <= v; i++)
		parent[i] = i;

	for (int i = 0; i < e; i++)
	{
		cin >> a >> b >> c;
		vec.push_back({ a, b, c });
	}
	
	sort(vec.begin(), vec.end(), _compare);
	
	for (int i = 0; i < vec.size(); i++)
	{
		if (find(vec[i].v) != find(vec[i].u))
		{
			connect(vec[i].v, vec[i].u);
			ans += vec[i].w;
		}
	}

	cout << ans;
	
	return 0;
}
