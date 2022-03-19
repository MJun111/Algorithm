#include <iostream>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100

int n, m, k;
int map[MAX][MAX];
bool visited[MAX][MAX];
int dx[4] = { -1, 0, 1, 0 };
int dy[4] = { 0, -1, 0, 1 };

void input()
{
    cin >> n >> m >> k;
    for (int i = 0; i < k; i++)
    {
        int a, b;
        cin >> a >> b;
        map[a-1][b-1] = 1;
    }
}

int DFS(int x, int y)
{
    visited[x][y] = true;
    int trash = 1;

    for (int i = 0; i < 4; i++)
    {
        int rx = x + dx[i];
        int ry = y + dy[i];

        if (rx >= 0 && rx < n && ry >= 0 && ry < m && !visited[rx][ry] && map[rx][ry])
            trash += DFS(rx, ry);
    }

    return trash;
}

void solution()
{
    int max = 0;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (!visited[i][j] && map[i][j])
            {
                int trash = DFS(i, j);
                max = trash >= max ? trash : max;
            }
        }
    }
    
    cout << max << "\n";
}

int main()
{
    input();
    solution();

    return 0;
}
