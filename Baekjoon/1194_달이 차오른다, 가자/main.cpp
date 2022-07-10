#include <iostream>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

struct s 
{
    int r, c, key, cnt;
};

int n, m;
int sr, sc;
char map[50][50];
bool visited[50][50][64];
int dir[4][2] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

void input()
{
    cin >> n >> m;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
        {
            cin >> map[i][j];
            if (map[i][j] == '0')
            {
                sr = i;
                sc = j;
            }
        }
}

bool haveKey(int cur_key, char door)
{
    if ((cur_key & (1 << (door - 'A'))) == 0) 
        return false;
    return true;
}

int getKey(int cur_key, char pick)
{
    return cur_key | (1 << (pick - 'a'));
}

int BFS()
{
    queue<s> q;
    q.push({ sr, sc, 0, 0 });
    visited[sr][sc][0] = true;

    while (!q.empty())
    {
        s cur = q.front();
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int nr = cur.r + dir[i][0];
            int nc = cur.c + dir[i][1];

            if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
            if (map[nr][nc] == '#') continue;
            if (visited[nr][nc][cur.key]) continue;
            
            // 1) ¹®
            if ('A' <= map[nr][nc] && map[nr][nc] <= 'F')
            {
                if (haveKey(cur.key, map[nr][nc]))
                {
                    q.push({ nr, nc, cur.key, cur.cnt + 1 });
                    visited[nr][nc][cur.key] = true;
                }
            }
            // 2) ¿­¼è
            else if ('a' <= map[nr][nc] && map[nr][nc] <= 'f')
            {
                int nKey = getKey(cur.key, map[nr][nc]);
                q.push({ nr, nc, nKey, cur.cnt + 1 });
                visited[nr][nc][nKey] = true;
            }
            // 3) ¸ñÀûÁö
            else if (map[nr][nc] == '1')
                return cur.cnt + 1;
            // 4) ºóÄ­
            else
            {
                q.push({ nr,nc,cur.key,cur.cnt + 1 });
                visited[nr][nc][cur.key] = true;
            }
        }
    }

    return -1;
}

void solution()
{
    cout << BFS() << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}