#include <iostream>
#include <vector>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100000 + 1

int n;
vector<int> vertex[MAX];
int parent[MAX];

void input()
{
    cin >> n;
    for (int i = 0; i < n - 1; i++)
    {
        int a, b;
        cin >> a >> b;
        vertex[a].push_back(b);
        vertex[b].push_back(a);
    }

    for (int i = 1; i <= n; i++)
        parent[i] = i;
}

void BFS()
{
    int root = 1;
    queue<int> q;
    q.push(root);

    while (!q.empty())
    {
        int top = q.front();
        q.pop();

        for (int i = 0; i < vertex[top].size(); i++)
        {
            int child = vertex[top][i];
            if (parent[child] == child)
            {
                parent[child] = top;
                q.push(child);
            }
        }
    }

    for (int i = 2; i <= n; i++)
        cout << parent[i] << "\n";
}

void solution()
{
    BFS();
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}