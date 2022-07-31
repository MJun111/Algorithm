#include <iostream>
#include <vector>
#include <queue>
#include <string>
#include <tuple>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1001

int n, m;
int map[MAX][MAX];
bool visited[MAX][MAX][2];
int dir[4][2] = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

void input()
{
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
    {
        string s;
        cin >> s;
        for (int j = 1; j <= m; j++)
            map[i][j] = s[j - 1] - '0';
    }
}

int BFS()
{
    queue<tuple<int, int, int, int>> q;
    q.push({ 1, 1, 1, 0 });
    visited[1][1][0] = true;

    while (!q.empty())
    {
        tuple<int, int, int, int> t = q.front();
        int r = get<0>(t);
        int c = get<1>(t);
        int cnt = get<2>(t);
        int breakWall = get<3>(t);
        q.pop();

        if (r == n && c == m)
            return cnt;

        for (int i = 0; i < 4; i++)
        {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if (nr < 1 || nc < 1 || nr > n || nc > m) continue;
            if (map[nr][nc] == 1 && breakWall == 0)
            {
                visited[nr][nc][breakWall + 1] = true;
                q.push({ nr, nc, cnt + 1, breakWall + 1 });
            }
            else if (map[nr][nc] == 0 && !visited[nr][nc][breakWall])
            {
                visited[nr][nc][breakWall] = true;
                q.push({ nr, nc, cnt + 1, breakWall });
            }
        }
    }
    return -1;
}

void solution()
{
    cout << BFS();
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}