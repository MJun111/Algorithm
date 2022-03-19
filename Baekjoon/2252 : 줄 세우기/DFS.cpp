#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int visited[32001];
vector<vector<int>> student(32001);
stack<int> ans;

void DFS(int n)
{
    visited[n] = true;
    for (int i = 0; i < student[n].size(); i++)
    {
        int tmp = student[n][i];
        if (!visited[tmp])
            DFS(tmp);
    }
    ans.push(n);
}

int main() {
    FAST
    int n, m;
    
    cin >> n >> m;
    

    while (m--)
    {
        int a, b;
        cin >> a >> b;
        student[a].push_back(b);
    }
    
    for (int i = 1; i <= n; i++)
    {
        if (!visited[i])
            DFS(i);
    }

    while (!ans.empty())
    {
        cout << ans.top() << " ";
        ans.pop();
    }
    
    return 0;
}
