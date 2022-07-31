#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100 + 1

int n, m;     
int time = 0;
bool check = false;
int cheese = 0;

int board[MAX][MAX];
bool visited[MAX][MAX];
int dr[4] = { -1, 0, 1, 0 };
int dc[4] = { 0, -1, 0, 1 };

void input()
{
    cin >> n >> m;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            cin >> board[i][j];
}

bool checkRange(int r, int c)
{
    if (r < 0 || r >= n || c < 0 || c >= m)
        return false;

    return true;
}

void BFS()
{
    queue<pair<int, int>> q;
    int cnt = 0;
    q.push({ 0, 0 });

    while (!q.empty())
    {
        int r = q.front().first;
        int c = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int rr = r + dr[i];
            int cc = c + dc[i];

            if (checkRange(rr, cc) && !visited[rr][cc])
            {
                visited[rr][cc] = true;

                if (board[rr][cc] == 0)
                    q.push({ rr, cc });
                else
                {
                    board[rr][cc] = 0;
                    cnt++;
                }
            }
        }
    }

    if (cnt == 0)
        check = true;
    else
    {
        cheese = cnt;
        time++;
        memset(visited, 0, sizeof(visited));
    }
}


void solution()
{
    while (!check) 
        BFS();
    
    cout << time << "\n" << cheese << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}