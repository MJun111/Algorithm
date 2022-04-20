#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 50 + 1

int n, root, erased;
vector<int> child[MAX];
int leaf[MAX];

void input()
{
    cin >> n;
    for (int i = 0; i < n; i++)
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
    cin >> erased;
}

void DFS(int x)
{
    if (child[x].empty())
        leaf[x] = 1;

    for (int y : child[x])
    {
        DFS(y);
        leaf[x] += leaf[y];
    }
}

void solution()
{
    for (int i = 0; i < n; i++)
        child[i].erase(remove(child[i].begin(), child[i].end(), erased), child[i].end());
     
    if (root != erased)
        DFS(root);
    
    cout << leaf[root] << "\n";
}

int main()
{
    FAST
        input();
    solution();

    return 0;
}