#include <iostream>
#include <cstring>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 501

int m, n, cnt;
int map[MAX][MAX];
int dp[MAX][MAX];
int dir[4][2] = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };

void input()
{
    cin >> m >> n;
    for (int i = 1; i <= m; i++)
        for (int j = 1; j <= n; j++)
            cin >> map[i][j];
}

int DFS(int r, int c)
{
    if (r == m && c == n) return 1;
    if (dp[r][c] != -1) return dp[r][c];
    dp[r][c] = 0;
    
    for (int i = 0; i < 4; i++)
    {
        int nr = r + dir[i][0];
        int nc = c + dir[i][1];
        if (nr < 1 || nc < 1 || nr > m || nc > n) continue;
        if (map[nr][nc] < map[r][c])
            dp[r][c] += DFS(nr, nc);
    }
    return dp[r][c];
}

void solution()
{
    memset(dp, -1, sizeof(dp));
    cout << DFS(1, 1) << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}