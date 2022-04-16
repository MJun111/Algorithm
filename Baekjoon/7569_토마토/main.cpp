#include <iostream>
#include <queue>
#include <cstring>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100 + 1

int m, n, h;
int arr[MAX][MAX][MAX];     // h, n, m -> 높이, 세로, 가로
int dir[6][3] = { {1, 0, 0}, {0, 1, 0}, {0, 0, 1}, {-1, 0, 0}, {0, -1, 0}, {0, 0, -1} };
bool visited[MAX][MAX][MAX];
int dist[MAX][MAX][MAX];

void input()
{
    cin >> m >> n >> h;

    for (int i = 0; i < h; i++)
        for (int j = 0; j < n; j++)
            for (int k = 0; k < m; k++)
                cin >> arr[i][j][k];
}

void BFS()
{
    memset(dist, -1, sizeof(dist));

    queue<int> q;

    for (int i = 0; i < h; i++)
        for (int j = 0; j < n; j++)
            for (int k = 0; k < m; k++)
                if (arr[i][j][k] == 1)
                {
                    q.push(i);
                    q.push(j);
                    q.push(k);
                    visited[i][j][k] = true;
                    dist[i][j][k] = 0;
                }

    while (!q.empty())
    {
        int _h = q.front(); q.pop();
        int _n = q.front(); q.pop();
        int _m = q.front(); q.pop();

        for (int i = 0; i < 6; i++)
        {
            int nh = _h + dir[i][0];
            int nn = _n + dir[i][1];
            int nm = _m + dir[i][2];

            if (nh < 0 || nn < 0 || nm < 0 || nh >= h || nn >= n || nm >= m) continue;
            if (arr[nh][nn][nm] == -1) continue;
            if (visited[nh][nn][nm]) continue;

            visited[nh][nn][nm] = true;
            dist[nh][nn][nm] = dist[_h][_n][_m] + 1;
            q.push(nh);
            q.push(nn);
            q.push(nm);
        }
    }

}

void solution()
{
    BFS();
    bool isFin = true;
    int ans = 0;
    for (int i = 0; i < h; i++)
        for (int j = 0; j < n; j++)
            for (int k = 0; k < m; k++)
            {
                if (dist[i][j][k] == -1 && arr[i][j][k] == 0)
                    isFin = false;

                ans = max(ans, dist[i][j][k]);
            }

    if (!isFin)
        ans = -1;

    cout << ans << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}