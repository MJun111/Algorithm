#include <iostream>
#include <cstring>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int n, m;
int map[301][301];
int tmp[301][301];
int dir[4][2] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
bool visited[301][301];

void input()
{
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= m; j++)
            cin >> map[i][j];
}

void melt()
{
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= m; j++)
        {
            if (map[i][j] != 0)
            {
                int sea = 0;
                for (int k = 0; k < 4; k++)
                {
                    int r = i + dir[k][0];
                    int c = j + dir[k][1];

                    if (r <= 0 || c <= 0 || r > n || c > m) continue;
                    if (map[r][c] == 0) sea++;
                }
                if (map[i][j] >= sea)
                    tmp[i][j] -= sea;
                else
                    tmp[i][j] = 0;
            }
        }
}

void BFS(int r, int c)
{
    queue<pair<int, int>> q;
    q.push({ r, c });
    while (!q.empty())
    {
        int nr = q.front().first;
        int nc = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int dr = nr + dir[i][0];
            int dc = nc + dir[i][1];

            if (dr <= 0 || dc <= 0 || dr > n || dc > m) continue;
            if (map[dr][dc] == 0) continue;
            if (visited[dr][dc]) continue;

            visited[dr][dc] = true;
            q.push({ dr, dc });
        }
    }
}

int getChunk()
{
    int cnt = 0;
    memset(visited, false, sizeof(visited));
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= m; j++)
        {
            if (map[i][j] != 0 && !visited[i][j])
            {
                visited[i][j] = true;
                BFS(i, j);
                cnt++;
            }
        }
    return cnt;
}

void solution()
{
    int year = 1;

    while (1)
    {
        memcpy(tmp, map, sizeof(map));
        melt();
        memcpy(map, tmp, sizeof(tmp));

        int chunk = getChunk();
        if (chunk == 0)
        {
            cout << "0\n";
            break;
        }
        else if (chunk > 1)
        {
            cout << year << "\n";
            break;
        }
        year++;
    }
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}