#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 10000 + 1

int n;
vector<int> arr[MAX];
int inDeg[MAX], T[MAX], T_Done[MAX];

void input()
{
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        int time;
        cin >> time;
        T[i] = time;

        int m;
        cin >> m;
        for (int j = 1; j <= m; j++)
        {
            int x;
            cin >> x;
            arr[x].push_back(i);
            inDeg[i]++;
        }
    }
}

void solution()
{
    queue<int> q;
    for (int i = 1; i <= n; i++)
        if (inDeg[i] == 0)
        {
            T_Done[i] = T[i];
            q.push(i);
        }

    while (!q.empty())
    {
        int x = q.front();
        q.pop();

        for (int y : arr[x])
        {
            inDeg[y]--;
            T_Done[y] = max(T_Done[x], T_Done[y]);

            if (inDeg[y] == 0)
            {
                T_Done[y] += T[y];
                q.push(y);
            }
        }
    }

    int ans = 0;
    for (int i = 2; i <= n; i++)
        ans = max(ans, T_Done[i]);

    cout << ans << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}