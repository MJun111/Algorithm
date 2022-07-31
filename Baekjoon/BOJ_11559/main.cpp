#include <iostream>
#include <cstring>
#include <vector>
#include <queue>
#include <map>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int field[13][7];
bool visited[13][7];
char c[6] = {'.', 'R', 'G', 'B', 'P', 'Y' };
map<char, int> m;
int dir[4][2] = { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };
vector<pair<int, int>> puyo;
int ans;

void setMap()
{
    for (int i = 0; i < 6; i++)
        m[c[i]] = i;
}

void input()
{
    for (int i = 12; i > 0; i--)
        for (int j = 1; j <= 6; j++)
        {
            char tmp;
            cin >> tmp;
            field[i][j] = m[tmp];
        }
}

void _pop(int r, int c, int color)
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
            
            if (dr <= 0 || dc <= 0 || dr > 12 || dc > 6) continue;
            if (field[dr][dc] != color) continue;
            if (visited[dr][dc]) continue;

            visited[dr][dc] = true;
            puyo.push_back({ dr, dc });
            q.push({ dr, dc});
        }
    }
}

void _search()
{
    bool isChain = false;
    memset(visited, false, sizeof(visited));

    for (int i = 12; i > 1; i--)
        for (int j = 1; j <= 6; j++)
        {
            if (field[i][j] != 0 && !visited[i][j])
            {
                puyo.clear();
                visited[i][j] = true;
                puyo.push_back({ i, j });
                _pop(i, j, field[i][j]);

                if (puyo.size() >= 4)
                {
                    isChain = true;
                    for (int k = 0; k < puyo.size(); k++)
                    {
                        int r = puyo[k].first;
                        int c = puyo[k].second;

                        while (r < 12)
                        {
                            field[r][c] = field[r + 1][c];
                            r++;
                        }
                        field[12][c] = 0;
                    }
                }
            }
        }

    if (isChain)
    {
        ans++;
        _search();
    }
    else
        return;
}

void solution()
{
    _search();
    cout << ans << "\n";
}

int main()
{
    FAST
    setMap();
    input();
    solution();

    return 0;
}