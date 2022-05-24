#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 200001

int n, root, giga, leaf;
vector<pair<int, int>> tree[MAX];
bool visited[MAX];

void input()
{
    cin >> n >> root;
    for (int i = 0; i < n - 1; i++)
    {
        int a, b, d;
        cin >> a >> b >> d;

        tree[a].push_back({ b, d });
        tree[b].push_back({ a, d });
    }
}

int findGiga(int len)
{
    if (tree[root].size() > 1 || tree[root].size() == 0)
    {
        giga = root;
        return 0;
    }
    len += tree[root][0].second;

    queue<int> q;
    int node = tree[root][0].first;
    q.push(node);

    int tmp = 0;
    while (!q.empty())
    {
        if (q.size() >= 2)
        {
            giga = node;
            return len;
        }
        len += tmp;
        node = q.front();
        visited[node] = true;
        q.pop();

        for (int i = 0; i < tree[node].size(); i++)
            if (!visited[tree[node][i].first])
            {
                q.push(tree[node][i].first);
                tmp = tree[node][i].second;
            }
    }
    return len;
}

int findLeaf(int node, int cnt)
{
    if (tree[node].size() == 1)
        return cnt;

    for (int i = 0; i < tree[node].size(); i++)
    {
        int next = tree[node][i].first;
        if (!visited[next])
        {
            visited[next] = true;
            leaf = max(leaf, findLeaf(next, cnt + tree[node][i].second));
        }
    }
    return leaf;
}

void solution()
{
    visited[root] = true;
    int giga_len = findGiga(0);
    int leaf_len = findLeaf(giga, 0);
    cout << giga_len << " " << leaf_len << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}