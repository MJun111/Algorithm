#include <iostream>
#include <vector>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 500000 + 1

int n, ans;
vector<int> arr[MAX];
bool visited[MAX];

void input()
{
    cin >> n;
    for (int i = 0; i < n - 1; i++)
    {
        int a, b;
        cin >> a >> b;
        arr[a].push_back(b);
        arr[b].push_back(a);
    }
}

void DFS(int node, int cnt)
{
    if (arr[node].size() == 1 && node != 1)
    {
        ans += cnt;
        return;
    }

    for (int i = 0; i < arr[node].size(); i++)
    {
        if (!visited[arr[node][i]])
        {
            visited[arr[node][i]] = true;
            DFS(arr[node][i], cnt + 1);
        }
    }
}

void solution()
{
    visited[1] = true;
    DFS(1, 0);

    if (ans % 2 == 1)
        cout << "Yes\n";
    else
        cout << "No\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}