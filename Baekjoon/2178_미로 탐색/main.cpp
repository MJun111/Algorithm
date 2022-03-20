#include <iostream>
#include <queue>
using namespace std;

#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 101

int n, m;
bool visited[MAX][MAX];         // 방문 여부
int length[MAX][MAX];           // 칸별 이동 거리
int maze[MAX][MAX];             // 미로
int dx[4] = { -1, 0, 1, 0 };    // 방향
int dy[4] = { 0, -1, 0, 1 };

void input()
{
    cin >> n >> m;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            scanf("%1d", &maze[i][j]);
}

void BFS(int x, int y)
{
    queue<pair<int, int>> q;
    q.push({ y, x });
    length[y][x] = 1;
    visited[y][x] = true;
    
    while (!q.empty())
    {
        int qx = q.front().second;
        int qy = q.front().first;
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int rx = qx + dx[i];
            int ry = qy + dy[i];

            if (rx >= 0 && ry >= 0 && rx < m && ry < n && maze[ry][rx] && !visited[ry][rx])
            {
                length[ry][rx] = length[qy][qx] + 1;
                visited[ry][rx] = true;
                q.push({ ry, rx });
            }
        }
    }

    cout << length[n - 1][m - 1] << "\n";
}

void solution()
{
    BFS(0, 0);
}

int main()
{
    input();
    solution();

    return 0;
}
