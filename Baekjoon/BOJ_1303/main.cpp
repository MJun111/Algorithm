#include <iostream>
#include <vector>
#include <string>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int n, m;
int wp = 0, bp = 0;
vector<string> soldier;
bool visited[101][101];
int dx[4] = { -1, 0, 1, 0 };
int dy[4] = { 0, -1, 0, 1 };

void input()
{
    cin >> n >> m;
    for (int i = 0; i < m; i++)
    {
        string tmp;
        cin >> tmp;
        soldier.push_back(tmp);
    }
}

int DFS(int x, int y, char sol)
{
    visited[x][y] = true;
    int power = 1;

    for (int i = 0; i < 4; i++)
    {
        int rx = x + dx[i];
        int ry = y + dy[i];

        if (rx >= 0 && rx < m && ry >= 0 && ry < n && !visited[rx][ry] && soldier[rx][ry] == sol)
            power += DFS(rx, ry, soldier[rx][ry]);
    }

    return power;
}

void solution()
{

    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (!visited[i][j])
            {
                int p = DFS(i, j, soldier[i][j]);
                soldier[i][j] == 'W' ? (wp += p * p) : (bp += p * p);
            }
        }
    }
    
    cout << wp << " " << bp << "\n";
}

int main()
{
    input();
    solution();

    return 0;
}
