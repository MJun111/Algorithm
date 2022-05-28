#include <iostream>
#include <cstring>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t, n, m;
int map[9][9];
int dir[8][2] = { {-1, 0}, {1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1} };

void conversion(int r, int c, int d)
{
    for (int i = 0; i < 8; i++)
    {
        vector<pair<int, int>> con;
        int nr = r + dir[i][0];
        int nc = c + dir[i][1];

        while (1)
        {
            if (nr <= 0 || nc <= 0 || nr > n || nc > n) break;
            if (map[nr][nc] == 0) break;
            if (map[nr][nc] == d)
            {
                for (int i = 0; i < con.size(); i++)
                    map[con[i].first][con[i].second] = d;
                break;
            }
            con.push_back({ nr, nc });
            nr += dir[i][0];
            nc += dir[i][1];
        }
    }
}

void solution()
{
    cin >> t;
    for (int tc = 1; tc <= t; tc++)
    {
        memset(map, 0, sizeof(map));
        cin >> n >> m;

        map[n / 2 + 1][n / 2] = 1;      // 1 : black, 2 : white
        map[n / 2][n / 2 + 1] = 1;
        map[n / 2][n / 2] = 2;
        map[n / 2 + 1][n / 2 + 1] = 2;

        for (int i = 1; i <= m; i++)
        {
            int a, b, c;
            cin >> a >> b >> c;
            map[a][b] = c;
            conversion(a, b, c);
        }

        int b = 0, w = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
            {
                if (map[i][j] == 1)
                    b++;
                if (map[i][j] == 2)
                    w++;
            }

        cout << "#" << tc << " " << b << " " << w << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}