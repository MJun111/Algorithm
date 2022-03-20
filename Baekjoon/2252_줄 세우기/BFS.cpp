#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int entry[32001];
vector<vector<int>> student(32001);

void BFS(int num)
{
    queue<int> q;
    for (int i = 1; i <= num; i++)
    {
        if (entry[i] == 0)
            q.push(i);
    }

    while(!q.empty()) 
    {
        int cur = q.front();
        q.pop();

        cout << cur << " ";

        for (int i = 0; i < student[cur].size(); i++)
        {
            int next = student[cur][i];
            
            entry[next]--;
            
            if (entry[next] == 0)
                q.push(next);
        }
    }
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
        entry[b]++;
    }

    BFS(n);
    

    return 0;
}
