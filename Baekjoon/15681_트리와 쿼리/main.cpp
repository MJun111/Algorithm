#include <iostream>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100000 + 1

int n, root, q;
vector<int> edge[MAX];
bool visited[MAX];
int vertex[MAX];

void input()
{
    cin >> n >> root >> q;
    for (int i = 0; i < n - 1; i++)
    {
        int u, v;
        cin >> u >> v;
        edge[u].push_back(v);
        edge[v].push_back(u);
    }
}

void DFS(int x)
{
    vertex[x] = 1;
    for (int y : edge[x])
        if (!visited[y])
        {
            visited[y] = true;
            DFS(y);
            vertex[x] += vertex[y];
        }
}

void solution()
{
    visited[root] = true;
    DFS(root);

    while (q-- > 0)
    {
        int sub;
        cin >> sub;
        cout << vertex[sub] << "\n";
    }
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}