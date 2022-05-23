#include <iostream>
#include <vector>
#include <string>
#include <cstring>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 101

int R, C, n;
string map[MAX];
vector<pair<int, int>> cluster;
bool visited[MAX][MAX];
bool flag;
int dir[4][2] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

void input()
{
    cin >> R >> C;
    for (int i = R - 1; i >= 0; i--)
        cin >> map[i];
}

void DFS(int r, int c)
{
    if (r == 0)
    {
        flag = true;
        return;
    }

    for (int j = 0; j < 4; j++)
    {
        int nr = r + dir[j][0];
        int nc = c + dir[j][1];

        if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
        if (map[nr][nc] == '.') continue;
        if (visited[nr][nc]) continue;

        visited[nr][nc] = true;
        cluster.push_back({ nr, nc });
        DFS(nr, nc);
    }
}

void fallCluster(int r, int c)
{
    for (int j = 0; j < 4; j++)
    {
        int nr = r + dir[j][0];
        int nc = c + dir[j][1];

        if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
        if (map[nr][nc] == '.') continue;

        memset(visited, false, sizeof(visited));
        cluster.clear();
        flag = false;

        visited[nr][nc] = true;
        cluster.push_back({ nr, nc });
        DFS(nr, nc);

        if (flag)
            continue;

        bool fall = true;
        while (fall)
        {
            for (int k = 0; k < cluster.size(); k++)
                map[cluster[k].first][cluster[k].second] = '.';

            for (int k = 0; k < cluster.size(); k++)
            {
                int dr = cluster[k].first - 1;
                int dc = cluster[k].second;

                if (dr < 0 || map[dr][dc] == 'x')
                {
                    fall = false;
                    break;
                }
            }

            for (int k = 0; k < cluster.size(); k++)
            {
                if (fall)
                    cluster[k].first--;

                map[cluster[k].first][cluster[k].second] = 'x';
            }
        }
    }
}

void solution()
{
    int h;
    bool dir = true;    // false -> left, true -> right
    cin >> n;
    while (n-- > 0)
    {
        cin >> h;

        int r = h - 1;
        int c = -1;

        dir = !dir;
        if (!dir)
        {
            for (int i = 0; i < C; i++)
                if (map[r][i] == 'x')
                {
                    c = i;
                    break;
                }
        }
        else
        {
            for (int i = C - 1; i >= 0; i--)
                if (map[r][i] == 'x')
                {
                    c = i;
                    break;
                }
        }

        if (c == -1)
            continue;

        map[r][c] = '.';

        fallCluster(r, c);
    }

    for (int i = R - 1; i >= 0; i--)
        cout << map[i] << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}