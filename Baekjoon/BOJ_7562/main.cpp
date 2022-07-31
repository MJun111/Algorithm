#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 300 + 1

int t;
int dir[8][2] = { {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1} };
int dist[MAX][MAX];

void BFS(int l, int sx, int sy, int gx, int gy)
{
    dist[sx][sy] = 0;

    queue<pair<int, int>> q;
    q.push({ sx, sy });

    while (!q.empty())
    {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for (int i = 0; i < 8; i++)
        {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx < 0 || ny < 0 || nx >= l || ny >= l) continue;
            if (dist[nx][ny] != -1) continue;

            q.push({ nx, ny });
            dist[nx][ny] = dist[x][y] + 1;
        }
    }
}

void solution()
{
    cin >> t;
    while (t-- > 0)
    {
        int l, sx, sy, gx, gy;

        cin >> l;
        cin >> sx >> sy;
        cin >> gx >> gy;

        memset(dist, -1, sizeof(dist));
        BFS(l, sx, sy, gx, gy);

        cout << dist[gx][gy] << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}