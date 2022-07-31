#include <iostream>
#include <vector>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1000 + 1

int n, m;
vector<int> arr[MAX];
bool visited[MAX];

void input()
{
    cin >> n >> m;
    for (int i = 0; i < m; i++)
    {
        int a, b;
        cin >> a >> b;
        arr[a].push_back(b);
        arr[b].push_back(a);
    }
}

void BFS(int x)
{
    visited[x] = true;
    queue<int> q;
    q.push(x);

    while (!q.empty())
    {
        int node = q.front();
        q.pop();

        for (int i = 0; i < arr[node].size(); i++)
        {
            if (visited[arr[node][i]]) continue;
            visited[arr[node][i]] = true;
            q.push(arr[node][i]);
        }
    }
}

void solution()
{
    int cnt = 0;
    
    for (int i = 1; i <= n; i++)
    {
        if (!visited[i])
        {
            BFS(i);
            cnt++;
        }
    }

    cout << cnt << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}