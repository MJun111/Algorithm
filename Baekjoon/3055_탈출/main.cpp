#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 50 + 1

int r, c;
string map[MAX];
int distW[MAX][MAX];    // 좌표까지 물이 차는데 걸리는 시간
int distH[MAX][MAX];    // 좌표까지 고슴도치가 가는데 걸리는 시간
bool visited[MAX][MAX];
int dir[4][2] = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };

void input()
{
    cin >> r >> c;
    for (int i = 0; i < r; i++)
        cin >> map[i];
}

void BFS_water()
{
    memset(visited, false, sizeof(visited));
    memset(distW, -1, sizeof(distW));
    
    queue<pair<int, int>> q;

    for (int i = 0; i < r; i++)
        for (int j = 0; j < c; j++)
            if (map[i][j] == '*')
            {
                q.push({ i, j });
                distW[i][j] = 0;
                visited[i][j] = true;
            }

    while (!q.empty())
    {
        int _r = q.front().first;
        int _c = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int nr = _r + dir[i][0];
            int nc = _c + dir[i][1];

            if (nr < 0 || nc < 0 || nr >= r || nc >= c) continue;
            if (map[nr][nc] == 'X' || map[nr][nc] == 'D') continue;
            if (visited[nr][nc]) continue;

            visited[nr][nc] = true;
            distW[nr][nc] = distW[_r][_c] + 1;
            q.push({ nr, nc });
        }
    }
}

void BFS_hedgehog()
{
    memset(visited, false, sizeof(visited));
    memset(distH, -1, sizeof(distH));

    queue<pair<int, int>> q;

    for (int i = 0; i < r; i++)
        for (int j = 0; j < c; j++)
            if (map[i][j] == 'S')
            {
                q.push({ i, j });
                distH[i][j] = 0;
                visited[i][j] = true;
            }

    while (!q.empty())
    {
        int _r = q.front().first;
        int _c = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int nr = _r + dir[i][0];
            int nc = _c + dir[i][1];

            if (nr < 0 || nc < 0 || nr >= r || nc >= c) continue;
            if (map[nr][nc] == 'X') continue;
            if (distW[nr][nc] != -1 && distW[nr][nc] <= distH[_r][_c] + 1) continue;
            if (visited[nr][nc]) continue;

            visited[nr][nc] = true;
            distH[nr][nc] = distH[_r][_c] + 1;
            q.push({ nr, nc });
        }
    }
}

void solution()
{
    BFS_water();
    BFS_hedgehog();
    
    for (int i = 0; i < r; i++)
        for (int j = 0; j < c; j++)
            if (map[i][j] == 'D')
            {
                if (distH[i][j] == -1)
                    cout << "KAKTUS\n";
                else
                    cout << distH[i][j] << "\n";
            }
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}