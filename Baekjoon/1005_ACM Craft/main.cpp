#include <iostream>
#include <queue>
#include <vector>
#include <cstring>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1000 + 1

int t, n, k, w;
int inDegree[MAX], T[MAX], T_Done[MAX];
vector<int> adj[MAX];

void input()
{
    memset(inDegree, 0, sizeof(inDegree));
    memset(T, 0, sizeof(T));
    memset(T_Done, 0, sizeof(T_Done));
    memset(adj, 0, sizeof(adj));

    cin >> n >> k;
    for (int i = 1; i <= n; i++)
        cin >> T[i];
    for (int i = 1; i <= k; i++)
    {
        int x, y;
        cin >> x >> y;
        adj[x].push_back(y);
        inDegree[y]++;
    }
    cin >> w;
}

void solution()
{
    cin >> t;
    while (t-- > 0)
    {
        input();

        queue<int> q;
        for (int i = 1; i <= n; i++)
            if (inDegree[i] == 0)
            {
                T_Done[i] = T[i];
                q.push(i);
            }

        while (!q.empty())
        {
            int x = q.front();
            q.pop();

            for (int y : adj[x])
            {
                inDegree[y]--;
                if (inDegree[y] == 0)
                    q.push(y);
                T_Done[y] = max(T_Done[y], T_Done[x] + T[y]);
            }
        }

        cout << T_Done[w] << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}