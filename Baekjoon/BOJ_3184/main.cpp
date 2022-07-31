#include <iostream>
#include <string>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 250 + 1

string backyard[MAX];
bool visited[MAX][MAX];
int r, c;
int ans_sheep = 0, ans_wolf = 0;
int dir[4][2] = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

void input()
{
    cin >> r >> c;
    for (int i = 0; i < r; i++)
        cin >> backyard[i];
}

void BFS(int a ,int b)
{
    queue<pair<int, int>> q;
    q.push({ a, b });

    int sheep = 0;
    int wolf = 0;

    while (!q.empty())
    {
        int _r = q.front().first;
        int _c = q.front().second;
        q.pop();

        if (backyard[_r][_c] == 'o')
            sheep++;
        if (backyard[_r][_c] == 'v')
            wolf++;

        for (int i = 0; i < 4; i++)
        {
            int nr = _r + dir[i][0];
            int nc = _c + dir[i][1];

            if (nr < 0 || nc < 0 || nr >= r || nc >= c) continue;
            if (visited[nr][nc]) continue;
            if (backyard[nr][nc] == '#') continue;

            visited[nr][nc] = true;
            q.push({ nr, nc });
        }
    }

    if (sheep > wolf)
        ans_sheep += sheep;
    else
        ans_wolf += wolf;       
}

void solution()
{
    for (int i = 0; i < r; i++)
        for (int j = 0; j < c; j++)
        {
            if ((backyard[i][j] == 'o' || backyard[i][j] == 'v') && !visited[i][j])
            {
                visited[i][j] = true;
                BFS(i, j);
            }
        }

    cout << ans_sheep << " " << ans_wolf << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}