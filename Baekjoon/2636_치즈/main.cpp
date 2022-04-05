#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100 + 1

int n, m;     
int time = 0;

int board[MAX][MAX];
bool air[MAX][MAX];      // 바깥 공기 영역

int dr[4] = { -1, 0, 1, 0 };
int dc[4] = { 0, -1, 0, 1 };

queue<pair<int, int>> q;
bool check = false;
vector<int> c;

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

void checkCheese()
{
    int cnt = 0;

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            if (board[i][j] == 1)
                cnt++;

    if (cnt == 0)
        check = true;
    else
        c.push_back(cnt);
}

void BFS()
{
    memset(air, false, sizeof(air));
    q.push({ 0, 0 });

    // 바깥 공기부분
    while (!q.empty())
    {
        int r = q.front().first;
        int c = q.front().second;
        q.pop();

        air[r][c] = true;

        for (int i = 0; i < 4; i++)
        {
            int rr = r + dr[i];
            int cc = c + dc[i];

            if (checkRange(rr, cc) && board[rr][cc] == 0 && air[rr][cc] == false)
                q.push({ rr, cc });
        }
    }

    // 지울 치즈 부분
    for (int i = 1; i < n - 1; i++)
        for (int j = 1; j < m - 1; j++)
            if (board[i][j] == 1)
            {
                for (int k = 0; k < 4; k++)
                {
                    int rr = i + dr[k];
                    int cc = j + dc[k];

                    if (air[rr][cc])
                    {
                        board[i][j] = 0;
                        break;
                    }
                }
            }

    time++;
}

void Print()
{
    cout << "\n\n";

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
            cout << board[i][j] << " ";
        cout << "\n";
    }
}

void solution()
{
    while (!check)
    {
        BFS();
        checkCheese();
    }
    cout << time << "\n";
    cout << c[c.size() - 1] << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}