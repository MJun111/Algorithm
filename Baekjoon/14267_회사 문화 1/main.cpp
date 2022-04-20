#include <iostream>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100000 + 1

int n, m, root;
vector<int> child[MAX];
int compliment[MAX];

void input()
{
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
    {
        int par;
        cin >> par;
        if (par == -1)
        {
            root = i;
            continue;
        }
        child[par].push_back(i);
    }
    for (int i = 1; i <= m; i++)
    {
        int p, w;
        cin >> p >> w;
        compliment[p] += w;
    }
}

void DFS(int x)
{
    for (int i = 0; i < child[x].size(); i++)
    {
        compliment[child[x][i]] += compliment[x];
        DFS(child[x][i]);
    }
}

void solution()
{
    DFS(1);
    for (int i = 1; i <= n; i++)
        cout << compliment[i] << " ";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}