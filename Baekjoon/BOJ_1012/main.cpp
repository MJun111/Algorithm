#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 50 + 1

int t, n, m, k;
int arr[MAX][MAX];
bool visited[MAX][MAX];
int dx[4] = { -1, 0, 1, 0 };
int dy[4] = { 0, -1, 0, 1 };

void BFS(int x, int y)
{
    visited[y][x] = true;

    queue<pair<int, int>> q;
    q.push({ x, y });

    while (!q.empty())
    {
        int _x = q.front().first;
        int _y = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int rx = _x + dx[i];
            int ry = _y + dy[i];

            if (rx < 0 || ry < 0 || rx >= m || ry >= n) continue;
            if (visited[ry][rx]) continue;
            if (arr[ry][rx] == 0) continue;

            visited[ry][rx] = true;
            q.push({ rx, ry });
        }
    }

}

void solution()
{
    cin >> t;

    while (t--)
    {
        cin >> m >> n >> k;
        for (int i = 0; i < k; i++)
        {
            int a, b;
            cin >> a >> b;
            arr[b][a] = 1;
        }

        int cnt = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (arr[i][j] == 1 && !visited[i][j])
                {
                    BFS(j, i);
                    cnt++;
                }
        cout << cnt << "\n";
        memset(arr, 0, sizeof(arr));
        memset(visited, false, sizeof(visited));
        
    }
}

int main()
{
    FAST
    solution();

    return 0;
}