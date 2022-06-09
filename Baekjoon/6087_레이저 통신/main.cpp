#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int w, h;
char map[101][101];
pair<int, int> c[2];        // c[0] : start position, c[1] : finish position
int visited[101][101];      // mirror cnt
int dir[4][2] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

struct Laser 
{
    int r;
    int c;
    int dir;
    int cnt;
};

void input()
{
    int x = 0;
    cin >> w >> h;
    for (int i = 0; i < h; i++)
        for (int j = 0; j < w; j++)
        {
            cin >> map[i][j];
            visited[i][j] = 987654321;
            if (map[i][j] == 'C')
            {
                c[x].first = i;
                c[x].second = j;
                x++;
            }
        }
}

int BFS(int a, int b)
{
    queue<Laser> q;
    for (int i = 0; i < 4; i++)
        q.push({ a, b, i, 0 });
    visited[a][b] = 0;

    while (!q.empty())
    {
        int r = q.front().r;
        int c = q.front().c;
        int Dir = q.front().dir;
        int Cnt = q.front().cnt;
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            int nCnt = Cnt;

            if (nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
            if (map[nr][nc] == '*') continue;
            if (Dir != i) nCnt++;
            if (visited[nr][nc] >= nCnt)
            {
                visited[nr][nc] = nCnt;
                q.push({ nr, nc, i, nCnt });
            }
        }
    }
    return visited[c[1].first][c[1].second];
}

void solution()
{
    cout << BFS(c[0].first, c[0].second);
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}