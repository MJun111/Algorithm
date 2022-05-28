#include <iostream>
#include <string>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t, n;
string map[21];
int dir[8][2] = { {1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, 1}, {1, -1}, {1, 1}, {-1, -1} };
bool ans;

void find_mok(int r, int c, int d, int cnt)
{
    if (cnt == 5)
    {
        ans = true;
        return;
    }
    int nr = r + dir[d][0];
    int nc = c + dir[d][1];

    if (nr < 0 || nc < 0 || nr >= n || nc >= n) return;
    if (map[nr][nc] != 'o') return;

    find_mok(nr, nc, d, cnt + 1);
}

void way(int r, int c)
{
    for (int i = 0; i < 8; i++)
    {
        if (ans)
            return;
        int nr = r + dir[i][0];
        int nc = c + dir[i][1];

        if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
        if (map[nr][nc] != 'o') continue;

        find_mok(nr, nc, i, 2);
    }
}

void solution()
{
    cin >> t;
    for (int tc = 1; tc <= t; tc++)
    {
        ans = false;
        cin >> n;
        for (int i = 0; i < n; i++)
            cin >> map[i];

        for (int i = 0; i < n; i++)
        {
            if (ans)
                break;
            for (int j = 0; j < n; j++)
            {
                if (ans)
                    break;
                if (map[i][j] == 'o')
                    way(i, j);
            }
        }
        cout << "#" << tc << " ";
        if (ans)
            cout << "YES\n";
        else
            cout << "NO\n";
    }
}

int main()
{
    FAST
        solution();

    return 0;
}